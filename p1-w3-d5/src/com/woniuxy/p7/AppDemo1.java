package com.woniuxy.p7;

public class AppDemo1 {
    public static void main(String[] args) {
        //读取属性文件创建一个学生对象，并且给学生对象赋值为配置文件中的属性值
        Student student = Factory.getBean("student.properties");
        System.out.println(student);
        //读取属性文件创建一个员工对象，并且给员工对象赋值为配置文件中的属性值
        Employee emp = Factory.getBean("employee.properties");
        System.out.println(emp);
    }
}
