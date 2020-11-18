package com.company;



public class Main {

    public static final String MY_NAME= "Yavor";

    public static void main(String[] args) {
	// write your code here
        Car volvo = new Car(2020);

        System.out.println(volvo.getYear());

        Singoleton singoleton= Singoleton.getInstance();

        singoleton.setText("Test");
        System.out.println(singoleton.getText());

        Singoleton singoleton1 = Singoleton.getInstance();

        singoleton1.setText("Second Text");

        System.out.println(singoleton.getText());

        Singoleton singoleton2 = Singoleton.getInstance();
        System.out.println(singoleton2.getText());




    }
}
