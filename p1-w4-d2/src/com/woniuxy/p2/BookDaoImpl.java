package com.woniuxy.p2;

import com.woniuxy.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BookDaoImpl implements BookDao {

    @Override
    public List<Book> getAllBooks() {
        String sql="select * from books";
        return executeQuery(sql);
    }

    @Override
    public Book getBookById(int id) {
        String sql="select * from books where id=?";
        Object[] params ={id};
        List<Book> books = executeQuery(sql, params);
        return books.get(0);
    }

    @Override
    public Integer addBook(Book book) {
        String sql = "insert into books (title, author, price, category) values (?,?,?,?)";
        Object[] params ={book.getTitle(), book.getAuthor(), book.getPrice(), book.getCategory()};
        return executeUpdate(sql,params);
    }

    @Override
    public Integer deleteBookById(int id) {
        String sql = "delete from books where id=?";
        Object[] params ={id};
        return executeUpdate(sql, params);
    }

    @Override
    public Integer updateBookById(int id, Book book) {
        String sql = "update books set title=?,author=?,price=?,category=? where id=?";
        Object[] params ={book.getTitle(), book.getAuthor(), book.getPrice(), book.getCategory(),id};
        return executeUpdate(sql, params);
    }

    @Override
    public List<Map<String, Object>> countBooksByCategory() {
        List<Map<String, Object>> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement("select category, count(*) as count from books group by category");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HashMap<String, Object> record =new HashMap<>();
                record.put("category", resultSet.getString(1));
                record.put("count",resultSet.getInt(2));
                list.add(record);
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
        Object[] params ={category};
        return executeQuery(sql,params);
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
        Object[] params = {(page-1) * pageSize, pageSize};
        return executeQuery(sql, params);
    }

    @Override
    public List<Book> getBooksSortedByPrice(int sortOrder) {
        String sql = sortOrder == 1 ? "select * from books order by price" : "select * from books order by price desc";
        return executeQuery(sql);
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
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }

            resultSet = statement.executeQuery();
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

    private Integer executeUpdate(String sql,Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);

            // 设置参数
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(connection, statement);
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
