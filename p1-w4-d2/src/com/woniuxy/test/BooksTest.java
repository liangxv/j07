package com.woniuxy.test;

import com.woniuxy.p2.Book;
import com.woniuxy.p2.BookDao;
import com.woniuxy.p2.BookDaoImpl;
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

        bookDao.addBook(new Book(null,"dsf","dsf",56.00,"sdf"));
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
