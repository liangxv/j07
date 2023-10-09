package com.woniuxy.p1;

import java.util.LinkedList;

public class AppDemo {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        list.addLast("lishi");
        System.out.println(list.removeFirst()+"结账");
        System.out.println(list.size());
        System.out.println(list.contains("王五"));

    }
}
