package com.woniu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据源工具类
 */
public class DataSourceUtil {

    //整个项目只需要创建一个连接池(数据源)
    private static DataSource dataSource;

    //在静态代码块中创建连接池
    static {
        //1.读取属性文件
        Properties properties = new Properties();
        try (InputStream inputStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("jdbc.properties")) {
            //属性值从文件中加载
            properties.load(inputStream);
            //2.通过属性文件创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据源
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接对象
     */
    public static Connection getConnection() throws SQLException {
        //从连接池中获取一个连接对象
        return dataSource.getConnection();
    }

    /**
     * 关闭所有的资源
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        //先关闭结果集
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭语句对象
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭连接对象
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭所有的资源
     */
    public static void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }
}
