package com.woniuxy.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplate {


    public  static  List<Map<String,Object>> queryForList(String sql, Object ...params){
        int row = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            setParams(statement, params);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Map<String,Object> map =new HashMap<>();
                map.put("category", resultSet.getString(1));
                map.put("count",resultSet.getInt(2));
                list.add(map);

            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection,statement,resultSet);
        }
    }

    public static Map<String,Object> queryForMap(String sql, Object ...params){

        return null;
    }

    private static void setParams(PreparedStatement statement, Object[] params) throws SQLException {
        ParameterMetaData metaData = statement.getParameterMetaData();
        int count = metaData.getParameterCount();
        for (int i = 0; i < count; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

}
