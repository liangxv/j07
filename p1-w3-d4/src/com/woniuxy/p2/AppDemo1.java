package com.woniuxy.p2;

public class AppDemo1 {
    public static void main(String[] args) {
        Car suv = CarFactory.createCar("SUV");
        Car sedan = CarFactory.createCar("sedan");
        Car truck = CarFactory.createCar("truck");
        suv.drive();
        sedan.drive();
        truck.drive();
    }

}
