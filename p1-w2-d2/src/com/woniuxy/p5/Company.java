package com.woniuxy.p5;

import java.util.Objects;

public class Company {
    private int id;//编号
    private String name; //企业名字
    private int year; //成立年份
    private String boss; //老板

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public Company(int id, String name, int year, String boss) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.boss = boss;
    }

    public Company( String name, int year, String boss) {
        this.id = new CompanyDao().nextId();
        this.name = name;
        this.year = year;
        this.boss = boss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (year != company.year) return false;
        if (!Objects.equals(name, company.name)) return false;
        return Objects.equals(boss, company.boss);
    }


    @Override
    public String toString() {
        return "\"Company\":{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"year\":" + year +
                ", \"boss\":\"" + boss + '\"' +
                '}';
    }
}
