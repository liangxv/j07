package com.woniuxy.p1;

public class AppDemo {
    public static void main(String[] args) {
        Books s1 = new Books();
        s1.publishingHouse = "清华大学出版社";
        s1.name = "kotori";
        Books s2 = new Books();
        System.out.println(s1);
        System.out.println(s2);
        add();
//        have();
    }

    public static void add() {
        AppDemo appDemo = new AppDemo();
        appDemo.have();
//        have();
    }

    public void have() {
        add();
    }
}
