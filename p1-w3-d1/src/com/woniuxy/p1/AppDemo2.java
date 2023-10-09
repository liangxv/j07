package com.woniuxy.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppDemo2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("张三", "一班", 90));
        students.add(new Student("李四", "一班", 85));
        students.add(new Student("王五", "二班", 92));
        students.add(new Student("赵六", "二班", 88));


        System.out.println(students);
        Map<String, Long> countClassName = students.stream().collect(Collectors.
                groupingBy(Student::getClassName, Collectors.counting()));

        countClassName.forEach((className,count)-> System.out.println(className+"有"+count+"人"));

        Map<String, List<Student>> listMap = students.stream().collect(Collectors.
                groupingBy((Student::getClassName), Collectors.toList()));

        listMap.forEach((className,studentss)-> System.out.println(className+"\t 名字\n"+studentss));





    }
}
