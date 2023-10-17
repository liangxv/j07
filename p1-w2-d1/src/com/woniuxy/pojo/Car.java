package com.woniuxy.pojo;

public class Car {
    String brand;
    String color;
    double price;

    public Car(){

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car(String brand, String color, double price){
        this.brand=brand;
        this.color=color;
        this.price=price;

    }

    @Override
    public String toString() {
        return "车{" +
                "品牌='" + brand + '\'' +
                ", 颜色='" + color + '\'' +
                ", 价格=" + price +
                '}';
    }
}
