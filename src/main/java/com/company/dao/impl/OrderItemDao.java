package com.company.dao.impl;

import com.company.dao.IOrderItemDao;
import com.company.entity.OrderItem;

public class OrderItemDao extends BaseDao implements IOrderItemDao{
    
    public int saveOrderItem(OrderItem orderItem) {

        String query = "INSERT INTO t_order_item (name, count, price, total_price, order_id) VALUES (?, ?, ?, ?, ?)";

        return update(query, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(),
                orderItem.getOrderId());
    }
}
