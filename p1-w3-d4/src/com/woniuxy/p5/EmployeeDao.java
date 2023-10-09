package com.woniuxy.p5;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDao implements  EmployeeImpl{

    // 数据文件路径
    final static String DB_FILE = "F:\\workspace\\j07\\p1-w3-d4\\src\\employee.txt";

    private List<Employee> employees;

    public EmployeeDao() {
        employees = fileToList();
    }

    // 查询所有员工
    @Override
    public List<Employee> findAll() {
        return fileToList();
    }

    // 根据年龄范围查询员工
    @Override
    public List<Employee> findBySalary(int starSalary, int endSalary) {
        return employees.stream()
                .filter(employee -> employee.getSalary() > starSalary && employee.getSalary() < endSalary)
                .collect(Collectors.toList());
    }

    // 根据部门分组统计员工数量
    @Override
    public Map<String, Long> groupByDepartment() {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepart, Collectors.counting()));
    }

    // 添加员工
    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        List<String> list = employees.stream().map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);

    }

    // 删除员工
    @Override
    public void delEmployee(int id) {
        List<String> list = employees.stream().filter(employee -> employee.getId() != id).map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    // 更新员工信息
    @Override
    public void updateEmployee(int id, Employee e) {
        employees.forEach(employee -> {
            if (employee.id == id) {
                employee.updateFrom(e);
            }
        });
        List<String> list = employees.stream().map(this::convertToString).collect(Collectors.toList());
        writeToFile(list);
    }

    // 获取下一个可用的员工ID
    private int nextId() {
        return employees.stream().mapToInt(Employee::getId).max().orElse(0) + 1;
    }

    // 创建新员工
    public Employee createEmployee(int id, String name, double salary, String depart) {
        id = nextId();
        return new Employee(id, name, salary, depart);
    }

    // 从文件读取数据并转换为员工列表
    private List<Employee> fileToList() {
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
    private void writeToFile(List<String> list) {
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
    private Employee convertToEmployee(String str) {
        String[] split = str.split("-");
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        double salary = Double.parseDouble(split[2]);
        String depart = split[3];
        return new Employee(id, name, salary, depart);

    }

    // 将员工对象转换为字符串
    private String convertToString(Employee employee) {
        return employee.getId() + "-" +
                employee.getName() + "-" +
                employee.getSalary() + "-" +
                employee.getDepart();
    }

    @Override
    public List<Employee> sortCompaniesBySalary(boolean ascending) {
        if (ascending) {
            employees.sort(Comparator.comparingDouble(Employee::getSalary));
        } else {
            employees.sort((c1, c2) -> Double.compare(c2.getSalary(), c1.getSalary()));
        }
        return employees;
    }
}
