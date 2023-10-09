package com.wonuixy;

import java.util.Scanner;

public class AppDemo4 {
    public static void main(String[] args) {
        System.out.print("请输入圆的半径：");
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        double area = m * m * Math.PI/2;
        double c = 2 * Math.PI * m;
        System.out.println("圆的面积是:" + area);
        System.out.println("圆的周长是:" + c);
    }
}
