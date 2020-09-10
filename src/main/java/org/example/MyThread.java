package org.example;

public class MyThread extends Thread{
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                System.out.println("Поток "+ getName() + "был завершен");
            } finally {
                System.out.println("Я поток " + getName() + ". Всем привет!");
            }
        }
    }
}
