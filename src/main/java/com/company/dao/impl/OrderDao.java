package com.company.dao.impl;

import com.company.dao.IOrderDao;
import com.company.entity.Order;

public class OrderDao extends BaseDao implements IOrderDao {

    public int saveOrder(Order order) {

        String query = "INSERT INTO t_order (id, create_time, price, status, user_id) VALUES (?, ?, ?, ?, ?)";

        return update(query, order.getId(), order.getCreateTime(), order.getPrice(), order.getStatus(),
                order.getUserId());
    }

}
