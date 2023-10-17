package com.woniuxy.pojo;

public class AppDemo1 {
    public static void main(String[] args) {
        BanKAccout banKAccout = new BanKAccout();
        banKAccout.deposit();
        System.out.println("得加钱"+banKAccout.balance);
        BanKAccout p2 = new BanKAccout();
        p2.withdrawal();
        System.out.println("取钱"+p2.balance);
        p2.inquire();
    }
}
