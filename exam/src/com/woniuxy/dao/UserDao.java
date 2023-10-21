package com.woniuxy.dao;

import com.woniuxy.pojo.User;

public interface UserDao {
    User login(String user, String password);

    Integer userRegistration(User user);
}
