package com.woniu.entity;

public class CustomerByGenderDTO {
    private String gender;
    private Long count;


    public CustomerByGenderDTO() {
    }

    public CustomerByGenderDTO(String gender, Long count) {
        this.gender = gender;
        this.count = count;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return count
     */
    public Long getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    public String toString() {
        return "CustomerByGender{gender = " + gender + ", count = " + count + "}";
    }
}
