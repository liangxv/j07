package com.woniuxy.pojo;

public class Truck implements Car {
    @Override
    public void drive() {
        System.out.println("驾驶卡车");
    }
}
