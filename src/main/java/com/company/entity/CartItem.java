package com.company.entity;

import java.math.BigDecimal;

public class CartItem {

    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;

    public CartItem(Integer id, String name, Integer count, BigDecimal price) {

        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = new BigDecimal(count).multiply(price);
    }

    public CartItem() {

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "CartItem {name: " + name + ", count: " + count + ", price: " + price + ", totalPrice: " + totalPrice
                + "}";
    }
}
