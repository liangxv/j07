package com.woniuxy.p4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDao {

    // 数据文件路径
    final static String DB_FILE = "F:\\workspace\\j07\\employee.txt";

    // 查询所有员工
    public List<Employee> findAll() {
        return fileToList();
    }

    // 根据年龄范围查询员工
    public List<Employee> findByAge(int starAge, int endAge) {
        return fileToList().stream()
                .filter(employee -> employee.getAge() > starAge && employee.getAge() < endAge)
                .collect(Collectors.toList());
    }

    // 根据部门分组统计员工数量
    public Map<String, Long> groupByDepartment() {
        return fileToList().stream().collect(Collectors.groupingBy(Employee::getDepart, Collectors.counting()));
    }

    // 添加员工
    public void addEmployee(Employee employee) {
        List<Employee> employees = fileToList();
        employees.add(employee);
        List<String> list = employees.stream().map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);

    }

    // 删除员工
    public void delEmployee(int id) {
        List<Employee> employees = findAll();
        List<String> list = employees.stream().filter(employee -> employee.getId() != id).map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    // 更新员工信息
    public void updateEmployee(int id, Employee e) {
        List<Employee> employees = findAll();
        employees.forEach(employee -> {
            if (employee.id == id) {
                employee.updateFrom(e);
            }
        });
        List<String> list = employees.stream().map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    // 获取下一个可用的员工ID
    public int nextId() {
        List<Employee> employees = findAll();
        return employees.stream().mapToInt(Employee::getId).max().orElse(0) + 1;
    }

    // 创建新员工
    public Employee createEmployee(int id, String name, int age, String depart) {
        id = nextId();
        return new Employee(id, name, age, depart);
    }

    // 从文件读取数据并转换为员工列表
    public List<Employee> fileToList() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(DB_FILE))) {
            String data;
            while ((data = in.readLine()) != null) {
                employees.add(convertToEmployee(data));
            }
            return employees;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 将员工列表写入文件
    public void writeToFile(List<String> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(DB_FILE))) {
            for (String s : list) {
                out.write(s);
                out.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 将字符串转换为员工对象
    public Employee convertToEmployee(String str) {
        String[] split = str.split("-");
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        int age = Integer.parseInt(split[2]);
        String depart = split[3];
        return new Employee(id, name, age, depart);

    }

    // 将员工对象转换为字符串
    public String convertToString(Employee employee) {
        return employee.getId() + "-" +
                employee.getName() + "-" +
                employee.getAge() + "-" +
                employee.getDepart();
    }
}
