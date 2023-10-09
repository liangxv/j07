package com.woniuxy.p4;

public class AppDemo3 {
    public static void main(String[] args) {
        Sportsman sportsman = new Sportsman();
        sportsman.eat();
        sportsman.sleep();
        sportsman.divingable();
        sportsman.swimmable();

    }
}

interface Human {
    void eat();

    void sleep();
}

interface Swimmable {
    void swimmable();
}

interface Divingable {
    void divingable();
}

abstract class Pepole implements Human {
    @Override
    public void sleep() {
        System.out.println("每天睡八小时");
    }
}

class Sportsman extends Pepole implements Swimmable, Divingable {
    @Override
    public void eat() {
        System.out.println("吃运动员套餐");
    }

    @Override
    public void swimmable() {
        System.out.println("跳水后游回去");
    }

    @Override
    public void divingable() {
        System.out.println("十米跳水");
    }
}