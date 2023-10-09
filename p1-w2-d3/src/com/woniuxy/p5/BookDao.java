package com.woniuxy.p5;

import java.util.ArrayList;
import java.util.Iterator;

public class BookDao {
    static ArrayList<Book> books = new ArrayList<>();

    public BookDao() {
        books.add(new Book(1, "约会大作站", 500.0, "橘公司", "富士见Fantasia文库"));
        books.add(new Book(2, "某科学的超电磁炮", 450.0, "魔法禁书目录", "电击文库"));
        books.add(new Book(3, "刀剑神域", 480.0, "川原礫", "电击文库"));
        books.add(new Book(4, "无彩限的怪灵世界", 550.0, "逢空万太", "讲谈社"));
        books.add(new Book(5, "魔法科高校的劣等生", 420.0, "佐岛勤", "电击文库"));
        books.add(new Book(6, "不正经的魔术讲师与禁忌教典", 490.0, "佐佐木友二", "电击文库"));
        books.add(new Book(7, "丧女", 420.0, "日日日", "讲谈社"));
        books.add(new Book(8, "Re:从零开始的异世界生活", 600.0, "长月达平", "MF文库J"));
        books.add(new Book(9, "只有我能进入的迷宫", 480.0, "蚕土豆", "讲谈社"));
        books.add(new Book(10, "轻音少女", 550.0, "樱高轻音部", "角川文库"));
        books.add(new Book(11, "我的妹妹不可能那么可爱！", 420.0, "伏见司", "电击文库"));
        books.add(new Book(12, "噬神者", 530.0, "田中ロミオ", "富士见Fantasia文库"));
        books.add(new Book(13, "高校龙的工作！", 480.0, "TAKAHIRO", "讲谈社"));
        books.add(new Book(14, "Angel Beats！", 460.0, "麻枝准", "角川文库"));
        books.add(new Book(15, "路人女主的养成方法", 490.0, "丸户史明", "富士见Fantasia文库"));
        books.add(new Book(16, "中二病也要谈恋爱！", 480.0, "虎虎", "电击文库"));
        books.add(new Book(17, "噬血狂袭", 550.0, "神原长江", "电击文库"));
        books.add(new Book(18, "天降之物！", 420.0, "苍井空", "电击文库"));
        books.add(new Book(19, "伊藤润二恐怖漫画精选", 490.0, "伊藤润二", "讲谈社"));
        books.add(new Book(20, "神的记事本", 480.0, "神", "讲谈社"));
    }


    public ArrayList<Book> findAll() {
        return books;
    }

    public Book finById(int index) {
        for (Book book : books) {
            if (book.getId() == index) {
                return book;
            }
        }
        return null;
    }


    public ArrayList<Book> finByAuthor(String author) {
        ArrayList<Book> newbooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    public ArrayList<Book> finbyKeywordsRange(String str) {
        ArrayList<Book> newbooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(str)) {
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    public ArrayList<Book> findByPriceRange(double low, double high) {
        ArrayList<Book> newbooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPrice() >= low && book.getPrice() <= high) {
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    public ArrayList<Book> findByPublishingHouseRange(String publishingHouse) {
        ArrayList<Book> newbooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublishingHouse().equals(publishingHouse)) {
                newbooks.add(book);
            }
        }
        return newbooks;
    }

    public int findByPublishingHouseCount(String publishingHouse) {
        int count = 0;
        for (Book book : books) {
            if (book.getPublishingHouse().equals(publishingHouse)) {
                count++;
            }
        }
        return count;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int nextId() {
        int max = 0;
        for (Book book : books) {
            if (book.getId() > max) {
                max = book.getId();
            }
        }
        return max + 1;
    }

    public int deleteBook(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                return 0;
            }

        }
        return -1;
    }

    public void updateBook(Book book, String title, int price, String author, String publishingHouse) {
        book.setTitle(title);
        book.setPrice(price);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);
    }
}
