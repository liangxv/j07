package com.woniuxy.p4;

public class Employee {
    int id;
    String name;
    int age;
    String depart;

    public Employee() {
    }

    public Employee(int id, String name, int age, String depart) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.depart = depart;
    }

    public void updateFrom(Employee employee){
        this.id = employee.id;
        this.name = employee.name;
        this.age = employee.age;
        this.depart = employee.depart;
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return depart
     */
    public String getDepart() {
        return depart;
    }

    /**
     * 设置
     * @param depart
     */
    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String toString() {
        return "id: " + id + "\tname: " + name + "\tage: " + age + "\tdepart: " + depart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

         return id != employee.id;
    }

}
