package org.example;

public class MyThread extends Thread{
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                Thread.sleep(3000);
                System.out.println(getName() + ". Всем привет!");
            } catch (InterruptedException e) {
                System.out.println(getName() + " был завершен");
                interrupt();
            }
        }
    }
}
