package com.woniuxy.p1;

public class AppDemo1 {
    public static void main(String[] args) {
        String[] cities = {"广州", "上海", "南京", "北京" };
        int[] nums = {12, 11, 24, 45, 44};

        for (String s :
                cities) {
            System.out.println(s);
        }

        for (int num :
                nums) {
            if (num % 4 == 0) {
                System.out.println(num);
            }
        }

    }
}
