package com.woniu.p1;

public class AppDemo4 {
    public static void main(String[] args) {
        String input = "65d5fg1";
        int sum = 0;
        char[] charArray = input.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (isInt(charArray[i])) {
                int j = i;
                while (isInt(charArray[j])) {
                    j++;
                    if (j == charArray.length) {
                        break;
                    }
                }
                String substring = input.substring(i, j);
                sum += Integer.parseInt(substring);
                i = j - 1;
            } else {
                sum += charArray[i] - 96;
            }
        }
        System.out.println(sum);

    }

    private static Boolean isInt(char c) {
        return c >= 48 && c <= 57;
    }
}
