package com.woniuxy.p3;

public class AppDemo1 {
    public static void main(String[] args) {
        Salesperson salesperson1 = new Salesperson();
        Manager salesperson = new Manager();
        salesperson.calculateSalary();
        salesperson1.calculateSalary();

    }
}

interface Employee {
    void calculateSalary();
}

class Salesperson implements Employee{

    

    @Override
    public void calculateSalary() {
        System.out.println("通过添加佣金来计算薪水");
    }
}

class Manager implements Employee{

    @Override
    public void calculateSalary() {
        System.out.println("通过添加奖金来计算薪水");
    }
}
