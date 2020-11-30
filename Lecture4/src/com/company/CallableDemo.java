package com.company;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Inside the callable method");
        Thread.sleep(10000);
        return "Return from callable";
    }
}
