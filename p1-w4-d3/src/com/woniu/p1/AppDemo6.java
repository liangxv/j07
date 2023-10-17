package com.woniu.p1;

import java.util.Scanner;

public class AppDemo6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine();
        int length = a.length() % 8;
        if (length!=0) {
            for (int i = length; i < 8; i++) {
                a=a+"0";
            }
        }
        for (int i = 0; i < a.length(); i+=8) {
            char[] charArray = a.substring(i, i + 8).toCharArray();
            for (char c : charArray) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
