package com.woniu.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Properties properties = new Properties();


        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

    }
}
