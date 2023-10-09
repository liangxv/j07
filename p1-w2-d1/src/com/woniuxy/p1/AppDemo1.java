package com.woniuxy.p1;

public class AppDemo1 {
    public static void main(String[] args) {
        SellBooks s1 = new SellBooks();
        SellBooks s2 = new SellBooks();
        s1.title = "约会大作战，";
        s1.price = "￥158";
        s1.author = "橘公司";
        s1.sell();

        s2.title = "刀剑神域";
        s2.price = "￥999";
        s2.author = "不知道";
        s2.sell();
        System.out.println("s2 = " + s2);
        System.out.println("s1 = " + s1);
    }

}
