package com.company.sync;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter.count=0;

        Object nameOfObject= new Object();
        synchronized (nameOfObject){
            nameOfObject.toString();
        }

        Counter counter=new Counter();
        ThreadNotSynced thread = new ThreadNotSynced();
        ThreadNotSynced second= new ThreadNotSynced();
        thread.counter=counter;
        second.counter=counter;
        Thread.sleep(1000L);
        System.out.println(Counter.count);
        Thread.sleep(1000L);
        thread.start();
        second.start();


        thread.join();
        second.join();

        System.out.println("Conter after threads is: " + Counter.count);
    }
}
