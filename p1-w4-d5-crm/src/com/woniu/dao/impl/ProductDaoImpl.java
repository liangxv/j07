package com.woniu.dao.impl;

import com.woniu.dao.BaseDao;
import com.woniu.dao.ProductDao;
import com.woniu.pojo.Product;

import java.util.List;

/**
 * 产品持久层
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {

    /**
     * 查询所有的产品
     */
    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product", Product.class);
    }

    /**
     * 查询某个客户购买了哪些产品
     */
    @Override
    public List<Product> findProductsByCustomerId(int customerId) {
        return jdbcTemplate.query("SELECT p.* FROM product p INNER JOIN cus_prod cp ON p.id = cp.prodId WHERE custId=?",
                Product.class, customerId);
    }

    @Override
    public List<Product> getAllProductById(int id) {
        return jdbcTemplate.query("select * from product where id=?", Product.class, id);
    }

    @Override
    public Integer addProduct(Product product) {
        return jdbcTemplate.update("insert into product (name, `describe`, price) value (" +
                "?,?,?)",product.getName(),product.getDescribe(),product.getPrice());
    }

    @Override
    public Integer deleteProduct(int id) {
        return null;
    }
}
