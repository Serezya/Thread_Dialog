package org.example;

import java.util.*;
import java.util.concurrent.*;

public class App
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        System.out.println("Создаю потоки...");
        String[] names = {"Thread-1", "Thread-2", "Thread-3", "Thread-4"};

        final ExecutorService threadPool = Executors.newFixedThreadPool(names.length);
        List<Future<Integer>> futures;
        List<MyCallable> myCallable = new ArrayList<>();


        for (String name : names) {
            myCallable.add(new MyCallable(name));
        }

        futures = threadPool.invokeAll(myCallable,15000, TimeUnit.MILLISECONDS);

        for (Future<Integer> future : futures) {
            if(!future.isCancelled())
                System.out.println(future.get());
        }

        threadPool.shutdown();
        System.out.println("Все потоки успешно завершены...");

    }
}
