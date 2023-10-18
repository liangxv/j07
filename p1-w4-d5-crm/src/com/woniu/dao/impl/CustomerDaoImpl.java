package com.woniu.dao.impl;

import com.woniu.dao.CustomerDao;
import com.woniu.entity.CustomerByGenderDTO;
import com.woniu.pojo.Customer;
import com.woniu.utils.JdbcTemplate;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "select * from crm.customer";
        return jdbcTemplate.query(sql, Customer.class);
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "select * from crm.customer where id=?";
        return jdbcTemplate.queryForObject(sql, Customer.class, id);
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        String sql = "select * from crm.customer where `name` like ?";
        String param = "%" + name + "%";
        return jdbcTemplate.query(sql, Customer.class, param);
    }

    @Override
    public List<Customer> getCustomersByPhoneNumber(String phoneNumber) {
        String sql = "select * from crm.customer where tel like ?";
        String param = "%" + phoneNumber + "%";
        return jdbcTemplate.query(sql, Customer.class, param);
    }

    @Override
    public List<Customer> getCustomersByGender(String gender) {
        String sql = "select * from crm.customer where gender=?";
        return jdbcTemplate.query(sql, Customer.class, gender);
    }

    @Override
    public List<CustomerByGenderDTO> getCustomerCountByGender() {
        String sql = "select gender,count(gender) count from crm.customer group by gender";
        return jdbcTemplate.query(sql, CustomerByGenderDTO.class);
    }

    @Override
    public Integer addCustomer(Customer customer) {
        String sql = "insert into crm.customer (name,tel,email,gender,birthday,empId) value (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, customer.getName(), customer.getTel(), customer.getEmail(),
                customer.getGender(), customer.getBirthday(), customer.getEmpId());

    }

    @Override
    public Integer updateCustomerById(Customer customer) {
        String sql = "UPDATE `crm`.`customer` SET `name` = ?, " +
                "`tel` = ?, " +
                "`email` = ?, " +
                "`gender` = ?, `birthday` = ?, " +
                "`empId` = ? WHERE `id` = ?";
        Object[] param = {customer.getName(), customer.getTel(), customer.getEmail(),
                customer.getGender(), customer.getBirthday(), customer.getEmpId(), customer.getId()};
        return jdbcTemplate.update(sql, param);
    }

    @Override
    public Integer deleteCustomerById(int id) {
        String sql = "delete from crm.customer where id=?";
        return jdbcTemplate.update(sql, id);

    }
}
