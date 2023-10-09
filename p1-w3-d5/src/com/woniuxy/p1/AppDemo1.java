package com.woniuxy.p1;

public class AppDemo1 {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("你好");
        list.add("你好世界");
        list.add("你好旅行者");

        System.out.println("第1个元素是:"+list.get(1));
        System.out.println("大小是:"+list.size());

        MyList<Integer> integerList = new MyList<>();
        integerList.add(80);
        integerList.add(60);
        integerList.add(30);
        System.out.println("第0个元素是"+integerList.get(0));
        System.out.println("大小是:"+integerList.size());
    }
}
