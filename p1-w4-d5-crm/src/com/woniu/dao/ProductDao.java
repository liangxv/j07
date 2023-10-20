package com.woniu.dao;

import com.woniu.pojo.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();

    public List<Product> findProductsByCustomerId(int customerId);
}
