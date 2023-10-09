package com.noniuxy.p2;

import java.util.Arrays;
import java.util.Random;

public class AppDemo3 {
    public static void main(String[] args) {
        double[] nums = new double[10];
        Random random = new Random();
        // 生成指定范围内的随机数
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextDouble() * 100;
        }
        System.out.println(Arrays.toString(nums));
        double mix = nums[0];
        double sum = 0.0;
        for (int j = 0; j < nums.length; j++) {
            // 找到数组中的最小值
            if (mix > nums[j]) {
                mix = nums[j];
            }
            //求和
            sum += nums[j];
        }
        System.out.println("最小值是：" + mix);
        System.out.println("平均值是：" + (sum / nums.length));
    }
}
