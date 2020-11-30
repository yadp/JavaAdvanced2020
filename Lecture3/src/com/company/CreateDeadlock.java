package com.company;

public class CreateDeadlock {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {

        // 1. Create and start thread 1
        // 2. Acquire lock1
        // 3.  Acquire lock2
        new Thread("Thread 01") {
            public void run() {
                synchronized (lock1) {
                    System.out.println("1.1 Thread 01 got lock 1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Thread 01 InterruptedException occured");
                    }
                    System.out.println("1.2 Thread 01 waiting for lock 2");
                    synchronized (lock2) {
                        System.out.println("Thread 01 got lock 2");
                    }
                }
            }
        }.start();



        new Thread("Thread 01") {
            public void run() {
                synchronized (lock2) {
                    System.out.println("1.1 Thread 01 got lock 1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Thread 01 InterruptedException occured");
                    }
                    System.out.println("1.2 Thread 01 waiting for lock 2");
                    synchronized (lock1) {
                        System.out.println("Thread 01 got lock 2");
                    }
                }
            }
        }.start();

        // 1. Create and start thre
    }
}