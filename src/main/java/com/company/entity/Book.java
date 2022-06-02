package com.company.entity;

public class Book {

    private Integer id;
    private String name;
    private Double price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String imgPath;

    public Book(Integer id, String name, Double price, String author, Integer sales, Integer stock, String imgPath) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        this.imgPath = imgPath;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
        this.imgPath = imgPath;
    }

    public String toString() {
        return "Book {name: " + name + ", price: " + price + ", author: " + author + ", sales: " + sales + ", stock: "
                + stock + "}";
    }
}
