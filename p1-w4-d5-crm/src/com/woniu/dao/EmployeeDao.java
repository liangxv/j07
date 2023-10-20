package com.woniu.dao;

import com.woniu.pojo.Employee;

public interface EmployeeDao {
    Employee login(String loginName, String password);

    int addEmployee(Employee employee);
}
