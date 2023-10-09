package com.woniuxy.p5;

import java.util.ArrayList;
import java.util.Scanner;

public class AppDemo1 {
    static Scanner scanner = new Scanner(System.in);
    static BookDao bookDao = new BookDao();

    public static void main(String[] args) {
        displayMenu();
        while (true) {
            int opthion = Integer.parseInt(getInput("请输入功能编号:"));
            switch (opthion) {
                case 1:
                    findAll();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    finbyKeywordsRange();
                    break;
                case 4:
                    findByAuthor();
                    break;
                case 5:
                    findByPriceRange();
                    break;
                case 6:
                    findByPublishingHouseRange();
                    break;
                case 7:
                    findByPublishingHouseCount();
                    break;
                case 8:
                    addBook();
                    break;
                case 9:
                    deleteBook();
                    break;
                case 10:
                    updateBook();
                    break;
                case 11:
                    displayMenu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入无效!");
                    break;

            }

        }
    }

    private static void updateBook() {
        int id = getInput("请输入书籍编号: ", true);
        Book book = bookDao.finById(id);
        if (book==null) {
            System.out.println("书库没有这个编号的数");
            return;
        }
        String title = getInput("请输入书名: ");
        int price = getInput("请输入价格:", true);
        String author = getInput("请输入作者的名字: ");
        String publishingHouse = getInput("请输入出版社的名称: ");
        bookDao.updateBook(book,title,price,author,publishingHouse);

    }

    private static void deleteBook() {
        int id = getInput("请输入书籍编号: ", true);
        if (bookDao.deleteBook(id)==0) {
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败,没有这个索引");
        }
    }

    private static void addBook() {
        String title = getInput("请输入书名: ");
        int price = getInput("请输入价格:", true);
        String author = getInput("请输入作者的名字: ");
        String publishingHouse = getInput("请输入出版社的名称: ");
        Book book = new Book(0, title, price, author, publishingHouse);
        book.setId(bookDao.nextId());
        bookDao.addBook(book);
        System.out.println("添加成功");
    }

    private static void findByPublishingHouseCount() {
        String publishingHouse = getInput("请输入出版社名称: ");
        int count = bookDao.findByPublishingHouseCount(publishingHouse);
        System.out.println(publishingHouse+"有"+count+"本书籍");
    }

    private static void findByPublishingHouseRange() {
        String publishingHouse = getInput("请输入出版社名称: ");
        ArrayList<Book> books = bookDao.findByPublishingHouseRange(publishingHouse);
        if (books.isEmpty()) {
            System.out.println("暂无查询结果");
            return;
        }
        printBooks(books);
    }

    private static void findByPriceRange() {
        int low = getInput("请输入最低价格:", true);
        int high = getInput("请输入最高价格", true);
        ArrayList<Book> books = bookDao.findByPriceRange(low, high);
        if (books.isEmpty()) {
            System.out.println("暂无查询结果");
            return;
        }
        printBooks(books);
    }

    private static void finbyKeywordsRange() {
        String s = getInput("输入书名的关键字");
        ArrayList<Book> books = bookDao.finbyKeywordsRange(s);
        if (books.isEmpty()) {
            System.out.println("暂无查询结果");
            return;
        }
        printBooks(books);

    }

    private static void findByAuthor() {
        String author = getInput("请输入作者的名字:");
        ArrayList<Book> books = bookDao.finByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("书库内暂无" + author + "的书籍");
            return;
        }
        printBooks(books);
    }

    private static void findById() {
        int id = getInput("请输入书籍的id:", true);
        Book book = bookDao.finById(id);
        if (book == null) {
            System.out.println("书库内暂无此" + id + "的书籍");
            return;
        }
        System.out.println(book);
    }

    private static void findAll() {
        ArrayList<Book> books = bookDao.findAll();
        printBooks(books);
    }

    private static void printBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void displayMenu() {
        System.out.println("========== 书籍管理系统 ==========");
        System.out.println("1. 查询所有书籍");
        System.out.println("2. 通过编号查询一本书籍");
        System.out.println("3. 根据书名关键字查询书籍");
        System.out.println("4. 根据作者查询书籍");
        System.out.println("5. 根据价格区间查询书籍");
        System.out.println("6. 根据出版社查询书籍");
        System.out.println("7. 根据出版社统计有多少本书籍");
        System.out.println("8. 新增书籍");
        System.out.println("9. 通过编号删除一本书籍");
        System.out.println("10. 通过编号修改一本书籍");
        System.out.println("11. 帮助");
        System.out.println("0. 退出系统");
        System.out.println("=================================");

    }

    public static String getInput(String str) {
        System.out.print(str);
        return scanner.next();
    }

    public static int getInput(String str, boolean isIntInput) {
        System.out.print(str);
        return scanner.nextInt();
    }


}

