package com.woniuxy.p4;

public class AppDemo2 {
    public static void main(String[] args) {
        CollegeStudent collegeStudent = new CollegeStudent("空", "物理", "量子力学");
        collegeStudent.introduce();
        collegeStudent.study();
        collegeStudent.research();
    }
}

class Person {
    private String name;

    public void introduce() {
        System.out.println("我的名字是" + name);
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person{
    private String grade;

    public Student(String name, String grade) {
        super(name);
        this.grade = grade;
    }

    public void study(){
        System.out.println(super.getName()+"在学习");
    }
}

class CollegeStudent extends Student {
    private String major;

    public CollegeStudent(String name, String grade, String major) {
        super(name, grade);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void research(){
        System.out.println(major+"研究方法力大砖飞");
    }

}