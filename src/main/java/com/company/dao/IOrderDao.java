package com.company.dao;

import com.company.entity.Order;
import com.company.entity.OrderItem;

public interface IOrderDao {

    public int saveOrder(Order order);

    public int saveOrderItem(OrderItem orderItem);
}
