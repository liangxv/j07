package com.woniu.dao;

import com.woniu.utils.DataSourceUtil;
import com.woniu.utils.JdbcTemplate;

/**
 * 创建一个持久层父类
 */
public class BaseDao {

    //protected 不同包中的子类可以使用，所有的子类可以直接使用这个对象
    protected JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceUtil.getDataSource());
}
