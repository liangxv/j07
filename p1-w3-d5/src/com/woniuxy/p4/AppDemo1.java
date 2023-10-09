package com.woniuxy.p4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AppDemo1 {
    public static void main(String[] args) throws Exception {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.getConstructor().newInstance();
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(student);
            }
        }
    }
}

class Student{
    public Student() {
    }

    @MyTest
    public void eat(){
        System.out.println("吃饭");
    }
    @MyTest
    public  void sleep(){
        System.out.println("睡觉");
    }

    public void study(){
        System.out.println("学习");
    }
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTest{

}
