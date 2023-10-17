package com.woniuxy.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppDemo1 {
    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<Employee>();
        emps.add(new Employee(1,"赵文卓","本科",11000));
        emps.add(new Employee(2,"黄飞鸿","大专",1400));
        emps.add(new Employee(3,"吴京","本科",13000));
        emps.add(new Employee(4,"李连杰","大专",9000));
        emps.add(new Employee(5,"李小龙","本科",20000));


        //1.遍历上述的集合

        emps.forEach(System.out::println);
        System.out.println();
        //2.找出工资在12000以上的人是哪些?3.统计工资在12000以上的有多少人
        long count = emps.stream().filter(employee -> employee.getSalary() > 1200).count();
        System.out.println("统计工资在12000以上的有"+count+"人\n");
        //4.找出李姓开始的人是哪些?
        emps.stream().filter(employee -> employee.getName().charAt(0)=='李').forEach(System.out::println);
        System.out.println();
        //5.找出学历是大专，工资在12000以上的人是哪些?
        emps.stream().filter(employee -> employee.getEdu().equals("大专")&&employee.getSalary()>1200).forEach(System.out::println);
        //6.统计学历是大专，工资在12000以上的人有多少个?
        long count1 = emps.stream().filter(employee -> employee.getEdu().equals("大专") && employee.getSalary() > 1200).count();
        System.out.println("历是大专，工资在12000以上的人有"+count1+"个");

    }
}
