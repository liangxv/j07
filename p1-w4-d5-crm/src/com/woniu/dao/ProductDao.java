package com.woniu.dao;

import com.woniu.pojo.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> findAll();

    public List<Product> findProductsByCustomerId(int customerId);

    public List<Product> getAllProductById(int id);

    Integer addProduct(Product product);

    Integer deleteProduct(int id);
}
