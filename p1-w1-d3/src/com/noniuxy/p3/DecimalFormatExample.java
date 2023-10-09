package com.noniuxy.p3;

import java.text.DecimalFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        // 创建一个 DecimalFormat 对象，指定保留两位小数的格式
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        // 要格式化的 double 数字
        double number = 123.456789;

        // 使用 DecimalFormat 格式化数字，保留两位小数并进行四舍五入
        String formattedNumber = decimalFormat.format(number);

        // 输出格式化后的结果
        System.out.println("格式化后的数字: " + formattedNumber);
    }
}

