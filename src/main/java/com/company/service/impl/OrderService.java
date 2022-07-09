package com.company.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.company.dao.impl.OrderDao;
import com.company.dao.impl.OrderItemDao;
import com.company.entity.Book;
import com.company.entity.Cart;
import com.company.entity.CartItem;
import com.company.entity.Order;
import com.company.entity.OrderItem;
import com.company.service.IOrderService;

public class OrderService implements IOrderService {

    OrderDao orderDao = new OrderDao();
    OrderItemDao orderItemDao = new OrderItemDao();
    private BookService bookService = new BookService();

    @Override
    public String createOrder(Cart cart, Integer userId) throws SQLException {

        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(),
                    item.getTotalPrice(), orderId);

            orderItemDao.saveOrderItem(orderItem);

            Book book = bookService.queryBookByID(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookService.updateBook(book);
        }

        return orderId;
    }

    @Override
    public List<Order> getMyOrders(Integer userId) throws SQLException {

        List<Order> orders = orderDao.queryOrdersByUserId(userId);

        return orders;
    }

    @Override
    public List<Order> getAllOrder() throws SQLException {

        List<Order> orders = orderDao.queryOrders();

        return orders;
    }

    @Override
    public int sendOrder(String id) throws SQLException {

        int statusCode = orderDao.changeOrderStatus(id, 1);

        return statusCode;
    }

    @Override
    public int accept(String id) throws SQLException {

        int statusCode = orderDao.changeOrderStatus(id, 2);

        return statusCode;
    }

    @Override
    public List<OrderItem> getOrderDetails(String id) throws SQLException {

        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId(id);

        return orderItems;
    }

}
