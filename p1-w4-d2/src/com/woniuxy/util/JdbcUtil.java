package com.woniuxy.util;

import java.sql.*;

public class JdbcUtil {
    //参数放在最上面，方便以后修改。URL可以简写，如果服务器名是localhost，并且端口号是3306，可以简写 jdbc:mysql:///woniu

    private static final String URL = "jdbc:mariadb://172.22.74.102:3306/woniu";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 释放资源
     */
    public static void close(Connection connection, Statement statement,
                             ResultSet resultSet) {
//关闭连接对象：先开的后关
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     */
    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

}
