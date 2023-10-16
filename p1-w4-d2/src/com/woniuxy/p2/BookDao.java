package com.woniuxy.p2;

import java.util.List;
import java.util.Map;

public interface BookDao {
    // 查询所有书籍
    List<Book> getAllBooks();

    // 通过ID查询一本书籍
    Book getBookById(int id);

    // 新增一本书籍
    Integer addBook(Book book);

    // 通过ID删除书籍
    Integer deleteBookById(int id);

    // 通过ID修改书籍
    Integer updateBookById(int id, Book updatedBook);

    // 统计每种分类下有几本书
    List<Map<String, Object>> countBooksByCategory();

    // 输出指定分类下有哪些书籍
    List<Book> getBooksByCategory(String category);

    // 查找价格区间的书籍有哪些
    List<Book> getBooksByPriceRange(double minPrice, double maxPrice);

    // 模糊查询指定关键字的书籍(关键字可以是书名或作者)
    List<Book> searchBooksByKeyword(String keyword);

    //.查询第几页的书籍，指定页码和页面大小
    List<Book> getBooksByPage(int page, int pageSize);

    //.按价格排序输出所有书籍(1-升序 0-降序)
    List<Book> getBooksSortedByPrice(int sortOrder);

    Boolean isExist(String str);
}
