package com.woniuxy.p3;

public class AppDemo {
    public static void main(String[] args) {
        System.out.println("圆的面积：" + calculateArea(4));
        System.out.println("矩形的面积：" + calculateArea(56, 5));
        System.out.println("三角形的面积：" + calculateArea(5, 4, 3));

    }

    public static double calculateArea(double radius) {
        return Math.pow(radius, 2) * Math.PI;
    }

    public static double calculateArea(double lenth, double width) {
        return lenth * width;
    }

    public static double calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
