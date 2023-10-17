package com.woniuxy.pojo;

public class BanKAccout {
    static {
        System.out.println("欢迎来到银行系统");
    }

    static String bankName =null;

    static void setName (){
        bankName="abc";
    }

    {
        System.out.println("账户已创建");
    }

    int balance=0;

    void deposit(){
        ++balance;
    }

    void withdrawal(){
        --balance;
    }

    void inquire (){
        System.out.println(balance);
    }

    public BanKAccout() {
        System.out.println("一个新的银行账户已被创建");
    }
}
