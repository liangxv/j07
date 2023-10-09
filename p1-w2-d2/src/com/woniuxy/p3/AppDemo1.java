package com.woniuxy.p3;

import java.util.ArrayList;

public class AppDemo1 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();
        strings.add("鸢一折纸");
        strings.add("时崎狂三");
        strings.add("四系乃");
        strings.add("五河琴里");
        strings.add("夜刀神十香");
        doubles.add(1.0);
        doubles.add(3.0);
        doubles.add(4.0);
        doubles.add(5.0);
        doubles.add(10.0);

        System.out.println(doubles.get(2));

        for (int i = 0; i < doubles.size(); i++) {
            Double aDouble = doubles.get(i);
            System.out.println(aDouble);
        }
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            System.out.println(s);
        }
    }
}
