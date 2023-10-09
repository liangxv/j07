package com.woniuxy.p2;

public class AppDemo2 {
    public static void main(String[] args) {
        Teacher s1 = new Teacher();
        s1.age = 22;
        s1.name = "李";
        s1.subject = "生物";
        Teacher s2 = new Teacher("刘", 18, "英语");
        System.out.println(s1);
        System.out.println(s2);
    }
}
