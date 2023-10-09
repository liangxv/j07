package com.woniuxy.p2;

import java.util.ArrayList;

public class AppDemo2 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"张三","男",8521));
        employees.add(new Employee(1,"李四","男",4561));
        employees.add(new Employee(1,"王五","男",8000));
        employees.add(new Employee(1,"七七","女",12000));

        employees.sort((o1, o2) -> o1.getWages()- o2.getWages());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

class Employee{
    private int id ;
    private String name;
    private String gender;
    private int wages;

    public Employee() {
    }

    public Employee(int id, String name, String gender, int wages) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.wages = wages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getWages() {
        return wages;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", wages=" + wages +
                '}';
    }
}