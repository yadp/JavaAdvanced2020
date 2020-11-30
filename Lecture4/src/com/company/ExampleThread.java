package com.company;

public class ExampleThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Print test message"+
                    Thread.currentThread().getName());
        }

    }
}
