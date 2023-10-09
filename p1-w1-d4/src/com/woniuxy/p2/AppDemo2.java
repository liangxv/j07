package com.woniuxy.p2;

public class AppDemo2 {
    public static void main(String[] args) {
        int[] arr = {34, 324, 234, 435, 6, 75, 456};
        System.out.println("最大的数是：" + findMax(arr));
        System.out.println("最小的数是: " + findMin(arr));
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }
}

