package com.company.sync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Counter {


    public  static volatile int count;

    public  static synchronized void increment()
    {
        count= count+1;
    }

    public void counterInc(){
        count++;
    }
}
