package com.woniuxy.p4;

public class Product {
    private int id; // 商品编号
    private String name; // 商品名称
    private double price; // 商品价格
    private int stock; // 商品库存
    private String category; // 商品分类

    public Product() {
    }

    public Product(int id, String name, double price, int stock, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
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
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * 设置
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * 获取
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return "{id = " + id + ", name = " + name + ", price = " + price + ", stock = " + stock + ", category = " + category + "}";
    }
}