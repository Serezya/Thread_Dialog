package org.example;

import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {
    private final String name;
    static int sleepTime = 3000;
    int countMessages;

    public MyCallable(String name) {
        this.name=name;
        this.countMessages = 0;
    }

    @Override
    public Integer call() {
        int countIter = 100;
        String msg = null;
        try {
            for (int i = 0; i < countIter; i++) {
                System.out.println(countMessages + ". " + name + ". Всем привет!");
                countMessages++;
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            msg = name + " отправил " +this.countMessages + " сообщений";
            System.out.println(msg);
            interrupt();
            System.out.println(name + " завершен");
        }
        return this.countMessages;
    }
}