package com.woniuxy.p2;

public class Employee {
    private int id;
    private String name;
    private String edu;
    private int salary;


    public Employee() {
    }

    public Employee(int id, String name, String edu, int salary) {
        this.id = id;
        this.name = name;
        this.edu = edu;
        this.salary = salary;
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
     * @return edu
     */
    public String getEdu() {
        return edu;
    }

    /**
     * 设置
     * @param edu
     */
    public void setEdu(String edu) {
        this.edu = edu;
    }

    /**
     * 获取
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "p2{id = " + id + ", name = " + name + ", edu = " + edu + ", salary = " + salary + "}";
    }
}
