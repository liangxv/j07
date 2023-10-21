package com.woniuxy.dao.impl;

import com.woniuxy.dao.BaseDao;
import com.woniuxy.dao.UserDao;
import com.woniuxy.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User login(String user, String password) {
        String sql ="select * from crm.user where name=? and password=?";
        return jdbcTemplate.queryForObject(sql, User.class, user, password);
    }

    @Override
    public Integer userRegistration(User user) {

        return jdbcTemplate.update("insert into crm.user (name, password) value (?,?)",
                user.getName(),user.getPassword());
    }
}
