package com.woniuxy.p3;

public class AppDemo2 {
    public static void main(String[] args) {
        String result = "";
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            if (i < 100) {
                result += (i + "+");
            } else {
                result += (i + "=");
            }
        }
        System.out.println(result+sum);
    }
}
