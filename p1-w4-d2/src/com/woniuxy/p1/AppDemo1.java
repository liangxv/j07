package com.woniuxy.p1;

import java.sql.*;

public class AppDemo1 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://172.22.74.102:3306/woniu","root","root");

//        String update = "INSERT INTO products VALUES (?, ?, ?, ?, ?);";
//        PreparedStatement preparedStatement = connection.prepareStatement(update);
//        preparedStatement.setNull(1, Types.NULL); // 第一个参数是占位符的索引，第二个参数是占位符的值
//        preparedStatement.setString(2, "iphone");
//        preparedStatement.setDouble(3, 9499.00);
//        preparedStatement.setInt(4, 9);
//        preparedStatement.setString(5, "数码");
//
//
//        int rowsAffected = preparedStatement.executeUpdate();
//        System.out.println(rowsAffected);

        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from products");
        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String type = resultSet.getString("type");

            System.out.println(id+name+price+type);
        }
        resultSet.close();
        preparedStatement1.close();
        connection.close();
    }
}
