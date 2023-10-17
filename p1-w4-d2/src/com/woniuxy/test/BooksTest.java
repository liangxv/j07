package com.woniuxy.test;

import com.woniuxy.pojo.Book;
import com.woniuxy.dao.BookDao;
import com.woniuxy.dao.impl.BookDaoImpl;
import org.junit.Test;

public class BooksTest {
    BookDao bookDao =new BookDaoImpl();
    @Test
    public void findAll(){

        bookDao.getAllBooks().forEach(System.out::println);
    }

    @Test
    public void getBookById(){

        System.out.println(bookDao.getBookById(2));

    }

    @Test
    public void addBook(){
        Book book =new Book();
        if ((!bookDao.isExist("dsafsaf"))) {
            System.out.println("已存在");
            return;
        }
        book.setTitle("dsafsaf");
        book.setAuthor("sdf");
        book.setCategory("小说");
        book.setPrice(56.00);
        bookDao.addBook(book);
    }

    @Test
    public void delBook(){
        System.out.println(bookDao.deleteBookById(1));
    }

    @Test
    public void getBooksByPage(){
        bookDao.getBooksByPage(1,3).forEach(System.out::println);
    }

    @Test
    public void getBooksSortedByPrice(){
        bookDao.getBooksSortedByPrice(2).forEach(System.out::println);
    }

    @Test
    public void countBooksByCategory(){
        bookDao.countBooksByCategory().forEach(System.out::println);
    }

    @Test
    public void u(){
        Book book = new Book(null, "sdf", "gfd", 78.0, "小说");
        bookDao.updateBookById(16,book);
    }
}
