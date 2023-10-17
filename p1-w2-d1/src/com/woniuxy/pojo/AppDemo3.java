package com.woniuxy.pojo;

public class AppDemo3 {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("保时捷","绿色",400000);

        car1.setBrand("奔驰");
        car1.setColor("黑色");
        car1.setPrice(200000);
        System.out.println("车{" +
                "品牌=\t'" + car1.getBrand() + '\'' +
                ", 颜色='" + car1.getColor() + '\'' +
                ", 价格=" + car1.getPrice() +
                '}');
        System.out.println(car2);
    }

}
