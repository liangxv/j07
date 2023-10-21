package com.woniu.dao;

import com.woniu.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee login(String loginName, String password);

    int addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    List<Employee> getEmployeeById(int id);
}
