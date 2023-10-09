package com.noniuxy.p3;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("快速排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 快速排序入口函数
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 分区函数，返回中轴索引
            int pivotIndex = partition(arr, low, high);
            // 递归排序左半部分
            quickSort(arr, low, pivotIndex - 1);
            // 递归排序右半部分
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // 分区函数，用于将数组分成两部分，小于中轴的放在左边，大于中轴的放在右边
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 选择中轴元素
        int i = low - 1; // 初始化左边界

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // 交换元素
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将中轴元素放到正确位置
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // 返回中轴索引
    }
}
