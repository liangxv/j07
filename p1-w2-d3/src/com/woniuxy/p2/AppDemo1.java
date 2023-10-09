package com.woniuxy.p2;

public class AppDemo1 {

    public static void main(String[] args) {
        Circle circle = new Circle(4);
        circle.calculateArea();
        circle.calculatePerimeter();

        Rectangle rectangle = new Rectangle(2, 5);
        rectangle.calculateArea();
        rectangle.calculatePerimeter();
    }
}

abstract class Shape {
    abstract void calculateArea();

    abstract void calculatePerimeter();
}

class Rectangle extends Shape {

    private double longg;
    private double wide;

    public Rectangle(double longg, double wide) {
        this.longg = longg;
        this.wide = wide;
    }

    public double getLongg() {
        return longg;
    }

    public void setLongg(double longg) {
        this.longg = longg;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    @Override
    void calculateArea() {
        double area = 2 * longg + 2 * wide;
        System.out.println("矩形的周长 = " + area);
    }

    @Override
    void calculatePerimeter() {
        double perimeter = longg * wide;
        System.out.println("矩形的面积 = " + perimeter);
    }
}

class Circle extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = 2 * radius * Math.PI;
        System.out.println("圆的周长: " + area);
    }

    @Override
    void calculatePerimeter() {
        double perimeter = Math.pow(radius, 2) * Math.PI;
        System.out.println("圆的面积 = " + perimeter);

    }
}
