package com.woniu.pojo;

public class Employee {
    private Integer id;
    private String userName;
    private String loginName;
    private String password;


    public Employee() {
    }

    public Employee(Integer id, String userName, String loginName, String password) {
        this.id = id;
        this.userName = userName;
        this.loginName = loginName;
        this.password = password;
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
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置
     * @param loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "employee{id = " + id + ", userName = " + userName + ", loginName = " + loginName + ", password = " + password + "}";
    }
}
