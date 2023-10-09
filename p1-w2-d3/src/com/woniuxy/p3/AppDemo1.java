package com.woniuxy.p3;

public class AppDemo1 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Duck duck = new Duck();
        cat.eat();
        cat.walk();
        duck.eat();
        duck.swimmable();
        duck.walk();
    }
}

interface Swimmable {
    void swimmable();
}

interface Animal{
    void eat() ;
    void walk();
}

class Cat implements Animal{

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void walk() {
        System.out.println("猫非常快的在走");
    }
}

class Duck implements Animal,Swimmable{

    @Override
    public void swimmable() {
        System.out.println("鸭子在水上游");
    }

    @Override
    public void eat() {
        System.out.println("鸭子吃虫");
    }

    @Override
    public void walk() {
        System.out.println("鸭子在走");
    }
}

