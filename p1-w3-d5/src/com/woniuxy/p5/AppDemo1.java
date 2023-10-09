package com.woniuxy.p5;

public class AppDemo1 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("张三");
        stringStack.push("李四");
        stringStack.push("王五");
        System.out.println(stringStack);

        System.out.println("弹出"+stringStack.pop());
        System.out.println(stringStack);
    }
}
