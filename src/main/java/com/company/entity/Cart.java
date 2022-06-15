package com.company.entity;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Integer totalCount = 0;
    private BigDecimal totalPrice = new BigDecimal("0.0");
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart(Integer totalCount, BigDecimal totalPrice, Map<Integer, CartItem> items) {

        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public Cart() {

    }

    public void addItem(CartItem item, Integer id) {
        CartItem cartItem = items.get(id);

        if (cartItem != null) {
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        } else {
            items.put(id, item);
        }

        this.setTotalCount(this.getTotalCount() + 1);
        this.setTotalPrice(this.getTotalPrice().add(item.getPrice()));
    }

    public void deleteItem(Integer id) {
        CartItem cartItem = items.remove(id);

        if (cartItem != null) {
            this.setTotalCount(this.getTotalCount() - cartItem.getCount());
            this.setTotalPrice(this.getTotalPrice().subtract(cartItem.getTotalPrice()));
        }
    }

    public void clearCart() {
        items.clear();
        this.setTotalCount(0);
        this.setTotalPrice(new BigDecimal("0.0"));
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);

        if (cartItem != null) {
            this.setTotalCount(this.getTotalCount() - cartItem.getCount());
            this.setTotalPrice(this.getTotalPrice().subtract(cartItem.getTotalPrice()));
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
            this.setTotalCount(this.getTotalCount() + cartItem.getCount());
            this.setTotalPrice(this.getTotalPrice().add(cartItem.getTotalPrice()));
        }
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public String toString() {
        return "Cart {totalCount: " + totalCount + ", totalPrice: " + totalPrice + "}";
    }

}
