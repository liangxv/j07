package com.woniuxy.pi;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AppDemo2 {
    private static final int NUM_COUNT = 8;      // 数组元素个数
    private static final int RANDOM_BOUND = 100; // 随机数范围

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[NUM_COUNT];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(RANDOM_BOUND) + 1;
        }
        AppDemo1.bubbleSort(true, nums);
        System.out.println("排序后" + Arrays.toString(nums));

        Scanner scanner = new Scanner(System.in);
        System.out.print("输入你要找的数: ");
        int target = scanner.nextInt();
        int index = binarySearch(nums, target);

        if (index == -1) {
            System.out.println("没有找到元素");
        } else {
            System.out.println("你要找的元素索引在：" + index);
        }
    }

    /**
     * 二分查找
     * @param nums 待查找的有序数组
     * @param target 目标元素
     * @return 目标元素的索引，如果不存在则返回 -1
     */
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }

    int a = 0;
}
