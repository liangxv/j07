package com.woniuxy.p1;

import java.util.HashMap;
import java.util.Map;

public class ApppDemo1 {
    public static void main(String[] args) {
        Map<String,Double> students = new HashMap<>();
        students.put("张三",99.0);
        students.put("李四",99.0);
        students.put("王五",99.0);
        students.put("赵六",99.0);

        System.out.println(students);

        System.out.println("修改张三的成绩");
        students.put("张三",100d);
        System.out.println("获取一个学生的成绩");
        System.out.println(students.get("张三"));
        students.remove("赵六");
        System.out.println(students.size());
        System.out.println(students);
        System.out.println(students.isEmpty());

    }
}
