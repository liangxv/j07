package com.woniuxy.dao.impl;

import com.woniuxy.dao.BookDao;
import com.woniuxy.entity.BooksByCategoryDTO;
import com.woniuxy.pojo.Book;
import com.woniuxy.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> getAllBooks() {
        String sql = "select * from books";
        return executeQuery(sql);
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from books where id=?";
        Object[] params = {id};
        List<Book> books = executeQuery(sql, params);
        return books.get(0);
    }

    @Override
    public Integer addBook(Book book) {
        String sql = "insert into books (title, author, price, category) values (?,?,?,?)";
        Object[] params = {book.getTitle(), book.getAuthor(), book.getPrice(), book.getCategory()};
        return executeUpdate(sql, params);
    }

    @Override
    public Integer deleteBookById(int id) {
        String sql = "delete from books where id=?";
        Object[] params = {id};
        return executeUpdate(sql, params);
    }

    @Override
    public Integer updateBookById(int id, Book book) {
        String sql = "update books set title=?,author=?,price=?,category=? where id=?";
        Object[] params = {book.getTitle(), book.getAuthor(), book.getPrice(), book.getCategory(), id};
        return executeUpdate(sql, params);
    }

    @Override
    public List<BooksByCategoryDTO> countBooksByCategory() {
        List<BooksByCategoryDTO> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement("select category, count(*) as count from books group by category");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BooksByCategoryDTO dto = new BooksByCategoryDTO();
                dto.setCategory(resultSet.getString("category"));
                dto.setCount(resultSet.getInt("count"));
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public List<Book> getBooksByCategory(String category) {
        String sql = "select * from books where category=?";
        Object[] params = {category};
        return executeQuery(sql, params);
    }

    @Override
    public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
        String sql = "select * from books where price between ? and ?";
        Object[] params = {minPrice, maxPrice};
        return executeQuery(sql, params);
    }

    @Override
    public List<Book> searchBooksByKeyword(String keyword) {
        String sql = "select * from books where title like ? or author like ?";
        Object[] params = {"%" + keyword + "%", "%" + keyword + "%"};
        return executeQuery(sql, params);
    }

    @Override
    public List<Book> getBooksByPage(int page, int pageSize) {
        String sql = "select * from books limit ?,?";
        Object[] params = {(page - 1) * pageSize, pageSize};
        return executeQuery(sql, params);
    }

    @Override
    public List<Book> getBooksSortedByPrice(int sortOrder) {
        String sql = sortOrder == 1 ? "select * from books order by price" : "select * from books order by price desc";
        return executeQuery(sql);
    }

    public Boolean isExist(String str) {
        String sql = "select * from books where title=?";
        Object[] params = {str};
        return (executeQuery(sql, params) == null);
    }


    private List<Book> executeQuery(String sql, Object... params) {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);

            // 设置参数
            setParams(statement, params);

            resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                return null;
            }

            while (resultSet.next()) {
                Book book = encapsulate(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection, statement, resultSet);
        }

        return books;
    }

    private Integer executeUpdate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            setParams(statement, params);

            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection, statement);
        }
    }

    private void setParams(PreparedStatement statement, Object[] params) throws SQLException {
        ParameterMetaData metaData = statement.getParameterMetaData();
        int count = metaData.getParameterCount();
        for (int i = 0; i < count; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }

    private Book encapsulate(ResultSet resultSet) throws SQLException {
        Book books = new Book();
        books.setId(resultSet.getInt(1));
        books.setTitle(resultSet.getString(2));
        books.setAuthor(resultSet.getString(3));
        books.setPrice(resultSet.getDouble(4));
        books.setCategory(resultSet.getString(5));
        return books;
    }


}
