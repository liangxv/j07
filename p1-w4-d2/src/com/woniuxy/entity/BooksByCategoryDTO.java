package com.woniuxy.entity;

public class BooksByCategoryDTO {
    private String category;
    private int count;


    public BooksByCategoryDTO() {
    }

    public BooksByCategoryDTO(String category, int count) {
        this.category = category;
        this.count = count;
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

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return "BooksByCategoryDTO{category = " + category + ", count = " + count + "}";
    }
}
