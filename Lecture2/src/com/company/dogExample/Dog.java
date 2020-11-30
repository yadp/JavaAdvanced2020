package com.company.dogExample;

public abstract class Dog {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Dog() {
        this.test="This is a new test";
    }

    public abstract void run();


    public void bark(){
        System.out.println("Dog Bark");
    }
}
