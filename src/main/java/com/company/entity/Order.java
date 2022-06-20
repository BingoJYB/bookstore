package com.company.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private Integer id;
    private Date createTime;
    private BigDecimal price;
    private Integer status = 0;
    private Integer userId;

    public Order(Integer id, Date createTime, BigDecimal price, Integer status, Integer userId) {
        this.id = id;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public Order() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String toString() {
        return "Order {price: " + price + ", createTime: " + createTime + ", status: " + status + "}";
    }
}
