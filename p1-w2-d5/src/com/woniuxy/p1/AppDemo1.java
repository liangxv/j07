package com.woniuxy.p1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppDemo1 {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        // 创建5个Book对象并添加到List集合中
        books.add(new Book(1, "活着", "余华", 29.8, LocalDate.of(2006, 1, 1)));
        books.add(new Book(2, "围城", "钱钟书", 39.5, LocalDate.of(1947, 9, 1)));
        books.add(new Book(3, "盗墓笔记", "南派三叔", 45.0, LocalDate.of(2006, 12, 1)));
        books.add(new Book(4, "三体", "刘慈欣", 59.9, LocalDate.of(2008, 1, 1)));
        books.add(new Book(5, "平凡的世界", "路遥", 49.8, LocalDate.of(1991, 1, 1)));

        //1. 使用流按价格的大小进行排序
        books.stream().sorted(Comparator.comparingDouble(Book::getPrice)).forEach(System.out::println);


        System.out.println();
        //2. 查询所有出版时间大于2005-01-01的书籍有哪些
        books.stream().filter(book -> (book.getPublishDate().compareTo(LocalDate.of(2005, 1, 1)))>0).forEach(System.out::println);
        //3. 统计价格大于40的书籍有几本
        long count = books.stream().filter(book -> book.getPrice() > 40).count();
        System.out.println("价格大于40的书籍有"+count+"本");
        //4. 查询出版时间最早的那一本书
        Book book = books.stream().min(Comparator.comparing(Book::getPublishDate)).get();
        System.out.println("出版时间最早的"+book);
        //5. 将所有书籍的书名映射成另一个List集合，其中每个元素是字符串类型
        List<String> list = books.stream().map(Book::getTitle).collect(Collectors.toList());
        System.out.println(list);
        //6. 计算所有书籍的价格总和
        double sum = books.stream().mapToDouble(Book::getPrice).sum();
        System.out.println("所有书籍的总和是"+sum);
    }
}
