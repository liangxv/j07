package com.woniuxy.p3;

import java.util.Scanner;

public class AppDemo2 {
    public static void main(String[] args) {
        System.out.print("请输入字符串: ");
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine(); // 使用 nextLine() 来读取整行字符串
        int vowelCount = countVowels(target);
        System.out.println("该字符串中的元音字母个数为: " + vowelCount);
    }

    public static int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isVowel(char c) {
        // 检查字符是否是元音字母（包括大写和小写）
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}
