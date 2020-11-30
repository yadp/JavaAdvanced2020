package com.company.executor;

import com.company.CallableImplementation;

import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args){
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new CallableImplementation());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

    }

    public static class ExecutorTestThread implements Runnable{



        @Override
        public void run() {
            System.out.println("Test");
        }
    }
}
