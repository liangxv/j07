package com.woniuxy.p1;

import java.util.Scanner;

public class AppDemo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入分数:");
        int i = scanner.nextInt();
        String rous = i>=60?"考试通过":"考试不通过";

        System.out.println(rous);
    }
}
