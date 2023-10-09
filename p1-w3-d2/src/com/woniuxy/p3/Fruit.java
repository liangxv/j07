package com.woniuxy.p3;

public class Fruit {

    private int id; // 水果编号
    private String name; // 水果名称
    private double price; // 水果价格
    private String origin; // 水果产地


    public Fruit() {
    }

    public Fruit(int id, String name, double price, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.origin = origin;
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
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String toString() {
        return "Fruit{id = " + id + ", name = " + name + ", price = " + price + ", origin = " + origin + "}";
    }
}