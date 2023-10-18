package com.woniuxy.dao.impl;

import com.woniuxy.dao.AccountDAO;
import com.woniuxy.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public Integer transfer(String from, String to, Integer money) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        connection.setAutoCommit(false);
        String sql1="update woniu.account set balance=balance-? where name=?";
        String sql2="update woniu.account set balance=balance+? where name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setInt(1,money);
        preparedStatement.setString(2,from);
        int row = preparedStatement.executeUpdate();

        return null;

    }
}
