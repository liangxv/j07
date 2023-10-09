package com.wonuixy;

/**
 * @author 梁栩
 * @version 1.0
 */

public class AppDemo1 {
    /*
     *public 公有的 static 静态的 void 无返回的方法
     * main 方法名
     */
    public static void main(String[] args) {
        //在控制台输出字符串
        System.out.println("你好，蜗牛学苑");
        //九九乘法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "X" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
