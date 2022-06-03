package com.company.entity;

import java.math.BigDecimal;

public class Book {

    private Integer id;
    private String name;
    private BigDecimal price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String imgPath = "static/img/default.jpg";

    public Book(Integer id, String name, BigDecimal price, String author, Integer sales, Integer stock,
            String imgPath) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        setImgPath(imgPath);
    }

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {

        if (imgPath != null && imgPath.length() > 0) {
            this.imgPath = imgPath;
        }
    }

    public String toString() {
        return "Book {name: " + name + ", price: " + price + ", author: " + author + ", sales: " + sales + ", stock: "
                + stock + "}";
    }
}
