package com.woniuxy.p1;

public class AppDemo1 {
    static Thread rabbit =new Thread(() -> {
        for (int i = 2; i <= 50; i=i+2) {
            System.out.println(i);
            try {
                // 休眠 500 毫秒
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    static Thread tortoise =new Thread(() -> {
        for (int i = 1; i < 50; i=i+2) {
            System.out.println(i);
            try {
                // 休眠 500 毫秒
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });

    public static void main(String[] args) {
        rabbit.start();
        tortoise.start();
//        Rabbit rabbit1 = new Rabbit();
//        Tortoise tortoise1 = new Tortoise();
//        rabbit1.start();
//        tortoise1.start();
    }
}

class Rabbit extends Thread{
    @Override
    public void run() {
        for (int i = 2; i <= 50; i=i+2) {
            System.out.println(i);
        }
    }
}

class Tortoise extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 50; i=i+2) {
            System.out.println(i);
        }
    }
}

