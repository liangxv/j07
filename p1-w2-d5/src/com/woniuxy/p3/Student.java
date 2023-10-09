package com.woniuxy.p3;

public class Student {
    private int id;
    private String name;
    private int age;
    private double grades;

    public Student() {
    }

    public Student(int id, String name, int age, double grades) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return grades
     */
    public double getGrades() {
        return grades;
    }

    /**
     * 设置
     * @param grades
     */
    public void setGrades(double grades) {
        this.grades = grades;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + ", grades = " + grades + "}";
    }
}
