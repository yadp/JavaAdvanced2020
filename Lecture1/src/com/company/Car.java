package com.company;

public class Car {
    String manufacturer;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    String model;
    private int year;

    public Car(int year){
        this.year = year;
    }

    public void setYear(int year){
        this.year=year;
    }

    public int getYear(){
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
