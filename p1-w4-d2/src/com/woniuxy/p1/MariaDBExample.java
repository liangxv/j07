package com.woniuxy.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariaDBExample {
    public static void main(String[] args) {
        // JDBC连接信息
        String jdbcUrl = "jdbc:mariadb://172.22.74.102:3306/woniu";
        String username = "root";
        String password = "root";

        try {
            // 加载MariaDB JDBC驱动
            Class.forName("org.mariadb.jdbc.Driver");

            // 建立数据库连接
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // 创建Statement对象
            Statement statement = connection.createStatement();

            // 执行SQL查询
            String sql = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(sql);

            // 处理查询结果
            while (resultSet.next()) {
                // 获取数据并进行处理
                String column1Data = resultSet.getString("name");
                String column2Data = resultSet.getString("age");
                // ... 可根据需要继续处理其他列
                System.out.println(column1Data + ", " + column2Data);
            }

            // 关闭连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
