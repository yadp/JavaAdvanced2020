package com.company;



public class Main {
    
    public static void main(String[] args) {
	// write your code here
        Animal[] zoo= new Animal[2];

        zoo[0] = new GoldenRetriever();
        zoo[1] = new GoldenRetriever();

        for(Animal ani:zoo){
            ani.sleep();
        }

        Dog animalGoldenDog = new GoldenRetriever();

        Dog animalGolden= new GoldenRetriever(5);

        animalGolden.getHair().toString();

        animalGoldenDog.getHair().toString();



    }

}


