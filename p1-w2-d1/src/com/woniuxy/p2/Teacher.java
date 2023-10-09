package com.woniuxy.p2;

public class Teacher {
    String name;
    int age;
    String subject;

    public Teacher(){
        System.out.println("创建一个教师类");
    }

    public Teacher(String name,int age,String subject){
        this();
        this.name=name;
        this.age=age;
        this.subject=subject;
    }

    @Override
    public String toString() {
        return "教师{" +
                "名字:'" + name + '\'' +
                ", 年龄:" + age +
                ", 科目:'" + subject + '\'' +
                '}';
    }
}
