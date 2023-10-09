package com.noniuxy.p2;

public class AppDemo2 {
    public static void main(String[] args) {
        int[] arr = {100, 5, 20, 10, 78};
        int conut = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                conut++;
            }
        }
        System.out.println("有" + conut + "个偶数");

        int[] nums = {12, -34, 23, -33, 8};
        conut = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 0) {
                conut++;
            }
        }
        System.out.println("有" + conut + "个负数");
    }
}
