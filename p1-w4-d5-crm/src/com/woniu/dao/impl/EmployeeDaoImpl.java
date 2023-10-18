package com.woniu.dao.impl;

import com.woniu.dao.EmployeeDao;
import com.woniu.pojo.Employee;
import com.woniu.utils.JdbcTemplate;

public class EmployeeDaoImpl implements EmployeeDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    @Override
    public Employee login(String loginName, String password) {
        String sql ="select * from crm.employee where loginName=? and password=?";
        return jdbcTemplate.queryForObject(sql, Employee.class, loginName, password);
    }
}
