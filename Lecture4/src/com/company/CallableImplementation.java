package com.company;

import java.util.concurrent.Callable;

public class CallableImplementation implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello message from callable";
    }
}
