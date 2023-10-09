package com.woniuxy.p6;

public class Commodity {
    private int id;
    private String name;
    private int price;
    private String type;

    public Commodity() {
    }

    public Commodity(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }


    /**
     * 获取
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Commodity{id = " + id + ", name = " + name + ", price = " + price + ", type = " + type + "}";
    }

    public void updateFrom(Commodity commodity) {
        this.id = commodity.id;
        this.name = commodity.name;
        this.price = commodity.price;
        this.type = commodity.type;
    }
}
