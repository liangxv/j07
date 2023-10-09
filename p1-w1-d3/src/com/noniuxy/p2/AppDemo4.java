package com.noniuxy.p2;

public class AppDemo4 {
    public static void main(String[] args) {
        String str = "misaka mikodo";

        // 返回字符串的长度
        System.out.println("字符串长度：" + str.length());

        // 返回指定索引处的字符值，索引从0开始
        System.out.println("索引3处的字符：" + str.charAt(3));

        // 检查字符串是否与给定字符串相等
        System.out.println("字符串是否等于\"misaka mikodo\"：" + str.equals("misaka mikodo"));

        // 检查字符串是否与给定字符串相等（忽略大小写）
        System.out.println("字符串是否等于\"Misaka Mikodo\"（不区分大小写）：" + str.equalsIgnoreCase("Misaka Mikodo"));

        // 查找子字符串的索引位置，如果找不到返回-1
        System.out.println("查找子字符串\"koto\"的索引位置：" + str.indexOf("koto"));

        // 提取从指定索引开始到字符串的末尾的子字符串
        System.out.println("从索引4开始的子字符串：" + str.substring(4));

        // 提取从指定索引开始到指定索引结束的子字符串
        System.out.println("从索引4到索引7的子字符串：" + str.substring(4, 8));

        // 检查字符串是否以指定前缀开头
        System.out.println("字符串是否以\"mi\"开头：" + str.startsWith("mi"));
    }
}
