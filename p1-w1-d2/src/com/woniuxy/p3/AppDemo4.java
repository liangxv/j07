package com.woniuxy.p3;

public class AppDemo4 {
    public static void main(String[] args) {
        int count = 0;
        double thickness = 0.1;
        double height = 8848860;
        while (thickness < height) {
            thickness*=2;
            count++;
            System.out.println("第"+count+"折叠后厚度为"+thickness);
        }
        System.out.println("折叠了"+count+"次");


    }
}
