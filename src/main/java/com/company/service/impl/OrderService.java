package com.company.service.impl;

import java.util.Date;

import com.company.dao.impl.OrderDao;
import com.company.dao.impl.OrderItemDao;
import com.company.entity.Cart;
import com.company.entity.CartItem;
import com.company.entity.Order;
import com.company.entity.OrderItem;
import com.company.service.IOrderService;

public class OrderService implements IOrderService {

    @Override
    public int createOrder(Cart cart, Integer userId) {
        int returnCode = -1;
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();

        String orderId = System.currentTimeMillis() + " " + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        returnCode = orderDao.saveOrder(order);

        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(),
                    item.getTotalPrice(), orderId);

            returnCode *= orderItemDao.saveOrderItem(orderItem);
        }

        return returnCode;
    }

}
