package org.example;

import java.util.*;
import java.util.concurrent.*;

public class App
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        System.out.println("Создаю потоки...");
        String[] names = {"Поток 1", "Поток 2", "Поток 3", "Поток 4"};

        final ExecutorService threadPool = Executors.newFixedThreadPool(names.length);
        List<Future<String>> futures;
        List<MyCallable> myCallable = new ArrayList<>();


        for (String name : names) {
            myCallable.add(new MyCallable(name));
        }

        futures = threadPool.invokeAll(myCallable,15000, TimeUnit.MILLISECONDS);

        for (Future<String> future : futures) {
            if(!future.isCancelled())
                System.out.println(future.get());
        }

        threadPool.shutdown();
        System.out.println("Все потоки успешно завершены...");

    }
}
