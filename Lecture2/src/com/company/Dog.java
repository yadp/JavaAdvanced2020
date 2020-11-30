package com.company;


public abstract class Dog implements Animal {
    private Hair hair;
    private int age;
    public Dog(){
        hair= new Hair();
    }

    public Dog(int age){
        hair= new Hair();
        this.age=age;
    }

    public abstract void run();
    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void bark(){
        System.out.print("Bark");
    }
}
