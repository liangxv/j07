package com.woniuxy.p2;

import java.util.ArrayList;

public class AppDemo1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("鸢一折纸");
        list.add("时崎狂三");
        list.add("四系乃");
        list.add("五河琴里");
        list.add("夜刀神十香");
        System.out.println(list);
        System.out.println("大小"+list.size());
        System.out.println("删除了" + list.remove("四系乃"));
        System.out.println("删除了" + list.remove(0));
        System.out.println(list);
        list.clear();
        System.out.println("集合是否为空"+list.isEmpty());
        System.out.println(list);
        list.add("鸢er折纸");
        list.add("时崎狂三");
        list.add("四系乃");
        list.add("五河琴里");
        list.add("夜刀神十香");
        System.out.println("修改了："+list.set(0,"鸢一折纸"));
        System.out.println(list);
        System.out.println(list.contains("本条二亚"));

    }
}
