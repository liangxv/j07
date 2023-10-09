package com.noniuxy.p2;

public class AppDemo1 {
    public static void main(String[] args) {
        String[] arr = {"kotori", "miku", "remu", "emiriya"};

        // 打印数组的第一个和第三个元素
        System.out.println("第一个元素" + arr[0]);
        System.out.println("第三个元素" + arr[2]);

        // 打印整个数组的元素
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
