package com.woniuxy.p1;

public class AppDemo1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.name="汽车";
        car.drive();
        car.addGas();

        Steamship steamship = new Steamship();
        steamship.name="轮船";
        steamship.drive();
        steamship.portOfCall();
    }
}

class Vehicle{
    String name;
    void drive(){
        System.out.println(name+"在驾驶");
    }
}

class Car extends Vehicle {
    void addGas(){
        System.out.println(super.name+"加油");
    }
}

class Steamship extends Vehicle {
    void portOfCall(){
        System.out.println(super.name+"停靠港口");
    }
}
