package com.woniu.dao.impl;

import com.woniu.dao.BaseDao;
import com.woniu.dao.EmployeeDao;
import com.woniu.pojo.Employee;

import java.util.List;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployee() {
        String sql ="select * from crm.employee";
        return jdbcTemplate.query(sql,Employee.class);
    }

    @Override
    public Employee login(String loginName, String password) {
        String sql ="select * from crm.employee where loginName=? and password=?";
        return jdbcTemplate.queryForObject(sql, Employee.class, loginName, password);
    }

    @Override
    public int addEmployee(Employee employee) {
        return jdbcTemplate.update("insert into employee values(null,?,?,?)",
                employee.getUserName(), employee.getLoginName(), employee.getPassword());
    }
}
