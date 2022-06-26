package com.company.dao.impl;

import java.util.List;

import com.company.dao.IOrderDao;
import com.company.entity.Order;

public class OrderDao extends BaseDao implements IOrderDao {

    public int saveOrder(Order order) {

        String query = "INSERT INTO t_order (id, create_time, price, status, user_id) VALUES (?, ?, ?, ?, ?)";

        return update(query, order.getId(), order.getCreateTime(), order.getPrice(), order.getStatus(),
                order.getUserId());
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {

        String query = "SELECT id, create_time createTime, price, status, user_id userId FROM t_order WHERE user_id = ?";
        return queryForList(Order.class, query, userId);
    }

}
