package com.company.sync;

public class ThreadNotSynced extends Thread{

    public Counter counter;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (counter) {
                counter.counterInc();
            }
        }
    }


}
