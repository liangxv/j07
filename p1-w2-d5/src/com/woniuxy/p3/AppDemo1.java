package com.woniuxy.p3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppDemo1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "张三", 18, 88));
        students.add(new Student(2, "张三", 19, 77));
        students.add(new Student(3, "张三", 23, 66));
        students.add(new Student(4, "张三", 25, 88));
        students.add(new Student(5, "张三", 17, 91));
        students.add(new Student(5, "张三", 26, 95));

        //1. 使用流按年龄的大小进行排序。
        students.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        System.out.println();
        //2. 查询成绩大于80的学生有哪些。
        students.stream().filter(student -> student.getGrades() > 80).forEach(System.out::println);
        System.out.println();
        //3. 统计年龄小于20的学生有几个。
        long count = students.stream().filter(student -> student.getAge() < 20).count();
        System.out.println("统计年龄小于20的学生有" + count + "个\n");
        //4. 查询成绩最高的学生。
        Student student = students.stream().max(Comparator.comparing(Student::getGrades)).get();
        System.out.println(student + "\n");
        //5. 将所有学生的姓名映射成另一个List集合，其中每个元素是字符串类型。
        List<String> list = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(list + "\n");
        //6. 计算所有学生的平均成绩。
        double averageGrades = students.stream().mapToDouble(Student::getGrades).average().getAsDouble();
        System.out.println("学生的平均成绩" + averageGrades + "\n");
        //7. 查询年龄最小的学生。
        Student minStudent = students.stream().min(Comparator.comparing(Student::getAge)).get();
        System.out.println("年龄最小的学生" + minStudent + "\n");
        //8. 查询成绩大于90且年龄大于25的学生有哪些
        students.stream().filter(student1 -> student1.getAge() > 25 && student1.getGrades() > 90).forEach(System.out::println);
    }
}
