package com.company.deadlock;

public class DeadlockExample {
    public static Object objectA = new Object();
    public static Object objectB = new Object();
    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println("First Thread");
            synchronized (objectA){
                System.out.println("First Thread inside sync A" + objectA.toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB){
                    System.out.println("First Thread inside sync B"+ objectB.toString() );
                }
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            System.out.println("Second Thread");
            synchronized (objectB){
                System.out.println("Second Thread inside sync B"+objectB.toString());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA){
                    System.out.println("Second Thread inside sync A"+ objectA.toString());
                }
            }
        }
    }

    public static void main(String[] args){
        Thread thread1= new Thread1();
        Thread thread2= new Thread2();
        thread1.start();
        thread2.start();


    }
}
