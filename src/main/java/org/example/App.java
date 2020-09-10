package org.example;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        System.out.println("Создаю потоки...");
        ThreadGroup group = new ThreadGroup("group-1");

        final Thread thread1 = new MyThread(group, "Поток 1");
        final Thread thread2 = new MyThread(group, "Поток 2");
        final Thread thread3 = new MyThread(group, "Поток 3");
        final Thread thread4 = new MyThread(group, "Поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(15000);
        System.out.println("Завершаю все потоки");
        group.interrupt();
    }
}
