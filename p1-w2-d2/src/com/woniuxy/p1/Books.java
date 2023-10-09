package com.woniuxy.p1;

public class Books {
    static String publishingHouse ;
    String name;
    String author;

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                "publishingHouse='" + publishingHouse + '\'' +
                '}';
    }
}
