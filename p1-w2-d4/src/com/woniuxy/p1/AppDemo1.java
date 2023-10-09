package com.woniuxy.p1;

public class AppDemo1 {
    public static void main(String[] args) {

        Animal rabbit = new Rabbit();
        rabbit.walk();
        Animal snail = new Snail();
        snail.walk();
        Snail snail1 = new Snail();
        snail1.eat();
    }
}

abstract class Animal {
    abstract void walk();
}

class Rabbit extends Animal {

    @Override
    void walk() {
        System.out.println("兔子走");
    }
}

class Snail extends Animal {
    @Override
    void walk() {
        System.out.println("蜗牛走");
    }

    void eat() {
        System.out.println("蜗牛吃");
    }
}
