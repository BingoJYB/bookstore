package com.company.dao;

import java.util.List;

import com.company.entity.OrderItem;

public interface IOrderItemDao {

    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);

}
