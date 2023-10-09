package com.woniuxy.p3;

public class AppDemo1 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 444};
        int target = 55;
        int index = findIndex(arr, target);

        if (index != -1) {
            System.out.println(target + " 的索引位置是：" + index);
        } else {
            System.out.println(target + " 未找到");
        }
    }

    public static int findIndex(int[] arr, int x) {
        // 遍历数组，查找元素 x 的索引位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; // 找到了，返回索引位置
            }
        }
        return -1; // 未找到，返回 -1
    }
}

