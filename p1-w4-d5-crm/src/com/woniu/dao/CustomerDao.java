package com.woniu.dao;

import com.woniu.entity.CustomerByGenderDTO;
import com.woniu.pojo.Customer;

import java.util.List;

public interface CustomerDao {
    // 获取所有客户
    List<Customer> getAllCustomers();

    // 根据ID获取客户
    Customer getCustomerById(int id);

    // 根据姓名模糊查询客户
    List<Customer> getCustomersByName(String name);

    // 根据电话号码模糊查询客户
    List<Customer> getCustomersByPhoneNumber(String phoneNumber);

    // 根据性别查询客户
    List<Customer> getCustomersByGender(String gender);

    // 返回每个性别下的客户数量
    List<CustomerByGenderDTO> getCustomerCountByGender();

    // 添加客户
    Integer addCustomer(Customer customer);

    // 根据ID更新客户信息
    Integer updateCustomerById(Customer customer);

    // 根据ID删除客户
    Integer deleteCustomerById(int id);
}
