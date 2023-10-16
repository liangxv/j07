package com.woniuxy.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    //参数放在最上面，方便以后修改。URL可以简写，如果服务器名是localhost，并且端口号是3306，可以简写 jdbc:mysql:///woniu

    private static final DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream stream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(stream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
