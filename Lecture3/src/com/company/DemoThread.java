package com.company;

public class DemoThread extends Thread{

    static int counter=0;

    public DemoThread(){

    }

    public synchronized void conterIncrement(){
        counter++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            conterIncrement();
            System.out.println("This is a new thread " +  Thread.currentThread().getName());
        }
    }
}
