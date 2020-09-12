package org.example;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private final String name;
    static int sleepTime = 3000;
    int countMessages;

    public MyCallable(String name) {
        this.name=name;
        this.countMessages = 0;
    }

    @Override
    public String call() {
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
        }
        System.out.println(name + " завершен");
        return msg;
    }
}