package com.woniuxy.p5;


import java.util.List;
import java.util.Map;

public interface EmployeeImpl{

    // 查询所有员工
     List<Employee> findAll();

    // 根据年龄范围查询员工
    List<Employee> findBySalary(int starSalary, int endSalary);

    // 根据部门分组统计员工数量
    Map<String, Long> groupByDepartment() ;

    // 添加员工
    void addEmployee(Employee employee) ;

    // 删除员工
    void delEmployee(int id) ;

    // 更新员工信息
    void updateEmployee(int id, Employee e) ;

    List<Employee> sortCompaniesBySalary(boolean ascending) ;
}

