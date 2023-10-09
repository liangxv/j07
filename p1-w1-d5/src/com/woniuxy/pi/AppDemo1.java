package com.woniuxy.pi;

import java.util.Arrays;
import java.util.Random;

public class AppDemo1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[8];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100) + 1;
        }
        System.out.println("排序前" + Arrays.toString(nums));
        bubbleSort(true, nums);
        System.out.println("排序后" + Arrays.toString(nums));
    }

    public static void bubbleSort(boolean b, int[] arr) {
        b = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (b) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }


                }

            }
        }
    }
}
