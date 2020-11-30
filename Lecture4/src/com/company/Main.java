package com.company;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args)  {

	// write your code here
        ExecutorService executorService= Executors.newCachedThreadPool();
        new Random().nextInt(100);

        Future<String> value = executorService.submit(new CallableDemo());

        Map<String,String> map = new ConcurrentHashMap<>();
        //code

        try {
            System.out.println("Before Get");
            System.out.println(value.get());
            System.out.println("After Get");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        executorService.shutdown();

    }
}
