package com.woniu.utils;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用的JDBC工具类
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取连接对象
     */
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭所有的资源
     */
    public void close(Connection connection, Statement statement, ResultSet resultSet) {
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
    public void close(Connection connection, Statement statement) {
        close(connection, statement, null);
    }

    /**
     * 实现增删改
     *
     * @param sql    要执行SQL语句
     * @param params 占位符值
     */
    public int update(String sql, Object... params) {
        int row = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //1.获取连接对象
            connection = getConnection();
            //2.获取语句对象
            statement = connection.prepareStatement(sql);
            //3.调用方法设置占位符的值
            setParameter(statement, params);
            //4.执行更新操作
            row = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement);
        }
        return row;
    }

    /**
     * 查询多条记录
     */
    public <T> List<T> query(String sql, Class<T> type, Object... params) {
        //创建一个集合
        List<T> list = new ArrayList<>();
        //声明三个对象
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1. 获取连接对象
            connection = getConnection();
            //2. 通过连接对象获取语句对象
            statement = connection.prepareStatement(sql);
            //给参数赋值
            setParameter(statement, params);
            //3. 发送SQL语句给数据库服务器
            resultSet = statement.executeQuery();
            //4. 获取数据库返回的结果集
            while (resultSet.next()) {
                //添加到集合中
                list.add(encapsulate(type, resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //5. 关闭连接，释放资源
            close(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * 查询1条记录
     */
    public <T> T queryForObject(String sql, Class<T> type, Object... params) {
        //调用上面的方法即可
        List<T> list = query(sql, type, params);
        //如果集合不为空
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 封装方法
     */
    private <T> T encapsulate(Class<T> type, ResultSet resultSet) {
        T obj = null;
        try {
            //获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取总列数
            int columnCount = metaData.getColumnCount();

            //1.通过反射创建对象
            obj = type.getConstructor().newInstance();
            //2.循环给每个成员变量赋值
            for (int i = 1; i <= columnCount; i++) {
                //获取列名
                String columnLabel = metaData.getColumnLabel(i);
                //获取结果集中数据
                Object value = resultSet.getObject(i);
                //通过反射获取实体类中属性对象
                Field field = type.getDeclaredField(columnLabel);
                //设置暴力反射
                field.setAccessible(true);
                //给属性赋值
                field.set(obj, value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //3.返回对象
        return obj;
    }

    /**
     * 设置参数的方法
     */
    private void setParameter(PreparedStatement statement, Object... params) throws SQLException {
        //3.1 获取参数元数据
        ParameterMetaData parameterMetaData = statement.getParameterMetaData();
        //3.2 获取参数的个数
        int count = parameterMetaData.getParameterCount();
        //3.3 给每个占位符赋值
        for (int i = 0; i < count; i++) {
            //每几个占位符，参数值
            statement.setObject(i + 1, params[i]);
        }
    }

    /**
     * 查询多条记录，每条记录是Map对象
     */
    public List<Map<String, Object>> queryForList(String sql, Object... params) {
        //创建一个集合
        List<Map<String, Object>> list = new ArrayList<>();
        //声明三个对象
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //1. 获取连接对象
            connection = getConnection();
            //2. 通过连接对象获取语句对象
            statement = connection.prepareStatement(sql);
            //给参数赋值
            setParameter(statement, params);
            //3. 发送SQL语句给数据库服务器
            resultSet = statement.executeQuery();
            //获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取有多少列
            int columnCount = metaData.getColumnCount();
            //4. 获取数据库返回的结果集
            while (resultSet.next()) {
                //每条记录封装成Map一个对象
                Map<String, Object> entry = new LinkedHashMap<>();
                //添加到集合中
                for (int i = 1; i <= columnCount; i++) {
                    //获取列名
                    String columnLabel = metaData.getColumnLabel(i);
                    entry.put(columnLabel, resultSet.getObject(i));
                }
                //将这条记录添加到集合中
                list.add(entry);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //5. 关闭连接，释放资源
            close(connection, statement, resultSet);
        }
        return list;
    }

    /**
     * 查询1条记录，封装成Map
     */
    public Map<String, Object> queryForMap(String sql, Object... params) {
        //直接调用上面的方法
        List<Map<String, Object>> list = queryForList(sql, params);
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
