package com.woniuxy.p2;

public class AppDemo1 {
    public static void main(String[] args) {
        String str= "UBUbbBhjvVvuihnUVBUnhjvNbvbNJHgvuiybIBHvnIBnKBNJBiuNVbuinBhnbHbiubuib@#￥%……&*（*&……%￥#￥%……&*（*&……%￥##￥%#$%^&**&^%$#$%^&16516516xwwwwwwwwwwwwwwwwwwwssssssssw";

        char[] chars = str.toCharArray();
        int big=0;
        int min=0;

        for (char aChar : chars) {
            if (aChar>='a'&& aChar<='z'){
                min++;
            }
            if (aChar>='A'&& aChar<='Z'){
                big++;
            }
        }
        System.out.println("大写字母有： "+big+"个");
        System.out.println("小写字母有： "+min+"个");
    }

    public static class Rectangle {
    }
}
