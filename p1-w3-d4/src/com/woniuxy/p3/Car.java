package com.woniuxy.p3;

public class Car {
    private String brand;  ///私有的：品牌
    public String color;   //公有的：颜色
    private int year;   //私有的：生产年份

    //私有的构造器
    private Car(String brand) {
        this.brand = brand;
    }

    public Car() {
    }

    public Car(String brand, String color, int year) {
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    //私有的方法
    private String startEngine() {
        System.out.println("启动引擎");
        return "启动引擎加速";
    }

    public void stop(String parking) {
        System.out.println("在" + parking + "停车");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
