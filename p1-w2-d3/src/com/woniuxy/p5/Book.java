package com.woniuxy.p5;

public class Book {
    private int id;
    private String title;
    private double price;
    private String author;
    private String publishingHouse;

    public Book(int id, String title, double price, String author,
                String publishingHouse) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String toString() {
        return "{"
                + "\"id\": " + id
                + ", \"title\": \"" + title + "\""
                + ", \"price\": " + price
                + ", \"author\": \"" + author + "\""
                + ", \"publishingHouse\": \"" + publishingHouse + "\""
                + "}";
    }
}
