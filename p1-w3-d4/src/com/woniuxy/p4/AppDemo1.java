package com.woniuxy.p4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AppDemo1 {
    public static void main(String[] args) throws Exception {
        Class<Teacher> teacherClass = Teacher.class;
        //公有构造器创建对象
        Teacher miku = teacherClass.getConstructor(String.class, int.class).newInstance("初音未来", 16);
        System.out.println(miku);

        //私有构造创建对象
        Constructor<Teacher> teacherConstructor = teacherClass.getDeclaredConstructor(String.class);
        teacherConstructor.setAccessible(true);
        Teacher kotori = teacherConstructor.newInstance("琴里");
        System.out.println(kotori);

        //调用公有方法
        String teacherInfo = (String) teacherClass.getMethod("getTeacherInfo").invoke(miku);
        System.out.println(teacherInfo);

        //调用私有方法
        Method m1 = teacherClass.getDeclaredMethod("calculateYearsOfExperience");
        m1.setAccessible(true);
        int ageYears = (int) m1.invoke(miku);
        System.out.println(m1.getName()+"返回的值是"+ageYears);

        //公有成员变量
        Field subject = teacherClass.getField("subject");
        subject.set(kotori,"日语");
        String s = (String) subject.get(kotori);
        System.out.println("获取值:"+s);
        System.out.println(kotori);

        //私有成员变量
        Field age = teacherClass.getDeclaredField("age");
        age.setAccessible(true);
        age.set(kotori,14);
        int kotoriAge = (int) age.get(kotori);
        System.out.println("获取值:"+kotoriAge);
        System.out.println(kotori);

    }
}
