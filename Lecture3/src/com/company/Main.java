package com.company;


public class Main {

    public static void main(String[] args)  {
        Runnable test = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is new thread");
            }
        };

        Thread thread= new Thread(test);
        thread.start();



    }
}
