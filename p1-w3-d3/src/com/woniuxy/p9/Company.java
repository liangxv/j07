package com.woniuxy.p9;

public class Company {
    private int id;//公司编号
    private String name;//公司名
    private String boss;//公司老板
    private int year;//公司创立年份

    public Company() {
    }

    public Company(int id, String name, String boss, int year) {
        this.id = id;
        this.name = name;
        this.boss = boss;
        this.year = year;
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
     * @return boss
     */
    public String getBoss() {
        return boss;
    }

    /**
     * 设置
     * @param boss
     */
    public void setBoss(String boss) {
        this.boss = boss;
    }

    /**
     * 获取
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Company{id = " + id + ", name = " + name + ", boss = " + boss + ", year = " + year + "}";
    }
}
