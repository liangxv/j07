package com.woniuxy.dao;

import java.sql.SQLException;

public interface AccountDAO {
    Integer transfer(String from,String to,Integer money) throws SQLException;
}
