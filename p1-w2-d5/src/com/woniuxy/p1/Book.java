package com.woniuxy.p1;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private LocalDate publishDate;
    public Book(int id, String title, String author, double price, LocalDate
            publishDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Book() {
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return publishDate
     */
    public LocalDate getPublishDate() {
        return publishDate;
    }

    /**
     * 设置
     * @param publishDate
     */
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }

}

