package com.company;

public class GoldenRetriever extends Dog {

    public GoldenRetriever(){
        super();
        //System.out.println("Constructor Golden");
    }

    public GoldenRetriever(int age){
        super(age);
        //System.out.println("Constructor Golden Age");
    }

    @Override
    public void run() {
        System.out.println("Run");
    }

    public void retrieve(){
        System.out.println("Retrieve");
    }

    @Override
    public void bark() {
        System.out.println("Golden Bark");
    }

    @Override
    public void sleep() {
        System.out.println("Golden Sleep");
    }
}
