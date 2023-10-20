package com.woniu.pojo;

/**
 * 产品实体类
 */
public class Product {

    private Integer id;
    private String name;
    private String describe;
    private Double price;


    public Product() {
    }

    public Product(Integer id, String name, String describe, Double price) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.price = price;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "Product{id = " + id + ", name = " + name + ", describe = " + describe + ", price = " + price + "}";
    }
}
