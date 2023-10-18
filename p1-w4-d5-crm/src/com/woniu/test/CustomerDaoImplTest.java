package com.woniu.test;

import com.woniu.dao.impl.CustomerDaoImpl;
import com.woniu.pojo.Customer;
import org.junit.Test;

import java.sql.Date;

public class CustomerDaoImplTest {
    CustomerDaoImpl customer =new CustomerDaoImpl();
    @Test
    public void testGetAllCustomers(){
        customer.getAllCustomers().forEach(System.out::println);
    }

    @Test
    public void testGetCustomerById(){
        System.out.println(customer.getCustomerById(3));
    }

    @Test
    public void testGetCustomersByName(){
        customer.getCustomersByName("空").forEach(System.out::println);
    }

    @Test
    public void testGetCustomersByPhoneNumber(){
        customer.getCustomersByPhoneNumber("8888").forEach(System.out::println);
    }
    @Test
    public void testGetCustomersByGender(){
        customer.getCustomersByGender("男").forEach(System.out::println);
    }

    @Test
    public void getCustomerCountByGender() {
        customer.getCustomerCountByGender().forEach(System.out::println);
    }

    @Test
    public void addCustomer() {
        Customer customers = new Customer(null,"白龙马","15888866332","bailongma@woniuxy.com",
                "男", Date.valueOf("2023-10-18"),2);
        System.out.println(customer.addCustomer(customers));
    }

    @Test
    public void updateCustomerById() {
        Customer customers = new Customer(6,"白龙马","15888866332","bailongma@woniuxy.com",
                "男", Date.valueOf("2023-10-18"),2);
        System.out.println(customer.updateCustomerById(customers));
    }

    @Test
    public void deleteCustomerById() {
        System.out.println(customer.deleteCustomerById(6));
    }
}
