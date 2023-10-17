package com.woniuxy.pojo;

import com.woniuxy.dao.BookDao;
import com.woniuxy.dao.impl.BookDaoImpl;

import java.util.Scanner;

public class BookManagerSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookDao bookDao = new BookDaoImpl();

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("1. 查询所有书籍");
            System.out.println("2. 通过ID查询一本书籍");
            System.out.println("3. 新增一本书籍");
            System.out.println("4. 通过ID删除书籍");
            System.out.println("5. 通过ID修改书籍");
            System.out.println("6. 统计每种分类下有几本书");
            System.out.println("7. 输出指定分类下有哪些书籍");
            System.out.println("8. 查找价格区间的书籍有哪些");
            System.out.println("9. 模糊查询指定关键字的书籍(关键字可以是书名或作者)");
            System.out.println("10.查询第几页的书籍，指定页码和页面大小");
            System.out.println("11.按价格排序输出所有书籍(1-升序 0-降序)");
            System.out.println("0. 退出");
            System.out.println("-----------------------");
            System.out.print("请输入您的选择：");
            choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    getAllBooks();
                    break;
                case 2:
                    getBookById();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    deleteBookById();
                    break;
                case 5:
                    updateBookById();
                    break;
                case 6:
                    countBooksByCategory();
                    break;
                case 7:
                    getBooksByCategory();
                    break;
                case 8:
                    getBooksByPriceRange();
                    break;
                case 9:
                    searchBooksByKeyword();
                    break;
                case 10:
                    getBooksByPage();
                    break;
                case 11:
                    getBooksSortedByPrice();
                    break;
                case 0:
                    System.out.println("已退出系统");
                    System.exit(0);
                    break;
                default:
                    System.out.println("无效的选择，请重新输入");
                    break;
            }
        }
    }

    private static void getBooksSortedByPrice() {
        System.out.print("按价格排序输出所有书籍(1-升序 0-降序): ");
        int sortOrder = scanner.nextInt();
        bookDao.getBooksSortedByPrice(sortOrder).forEach(System.out::println);
    }

    private static void getBooksByPage() {
        System.out.print("请输入页码: ");
        int page = scanner.nextInt();
        System.out.print("请输入页面大小: ");
        int pageSize = scanner.nextInt();
        bookDao.getBooksByPage(page, pageSize).forEach(System.out::println);
    }

    private static void searchBooksByKeyword() {
        System.out.println("请输入关键字：");
        String keyword = scanner.next();
        bookDao.searchBooksByKeyword(keyword).forEach(System.out::println);
    }

    private static void getBooksByPriceRange() {
        System.out.print("请输入最小的价格：");
        double minPrice = scanner.nextDouble();
        System.out.print("请输入最大的价格：");
        double maxPrice = scanner.nextDouble();
        bookDao.getBooksByPriceRange(minPrice, maxPrice).forEach(System.out::println);
    }

    private static void getBooksByCategory() {
        System.out.print("请输入分类：");
        String category = scanner.next();
        bookDao.getBooksByCategory(category).forEach(System.out::println);

    }

    private static void countBooksByCategory() {
        bookDao.countBooksByCategory().forEach(System.out::println);

    }

    private static void updateBookById() {
        System.out.print("请输入要删除的id: ");
        int id = scanner.nextInt();
        System.out.print("请输入书名：");
        String title = scanner.next();
        System.out.print("请输入作者的名字：");
        String author = scanner.next(); //字符串
        System.out.print("请输入价格：");
        double price = scanner.nextDouble();
        System.out.print("请输入分类：");
        String category = scanner.next();
        Book book = new Book(id, title, author, price, category);
        if (bookDao.updateBookById(id, book)>0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    private static void deleteBookById() {
        System.out.print("请输入要删除的id: ");
        int id = scanner.nextInt();
        if (bookDao.deleteBookById(id) > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    private static void addBook() {
        System.out.print("请输入书名：");
        String title = scanner.next();
        System.out.print("请输入作者的名字：");
        String author = scanner.next(); //字符串
        System.out.print("请输入价格：");
        double price = scanner.nextDouble();
        System.out.print("请输入分类：");
        String category = scanner.next();
        Book book = new Book(null, title, author, price, category);
        int row = bookDao.addBook(book);
        if (row > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    private static void getBookById() {
        System.out.print("请输入要查找的id: ");
        int id = scanner.nextInt();
        System.out.println(bookDao.getBookById(id));
    }

    private static void getAllBooks() {
        bookDao.getAllBooks().forEach(System.out::println);
    }

}
