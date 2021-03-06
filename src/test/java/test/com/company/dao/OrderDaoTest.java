package test.com.company.dao;

import com.company.dao.impl.OrderDao;
import com.company.entity.Order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDaoTest {

    private OrderDao orderDao;

    @BeforeEach
    void setUp() {

        orderDao = new OrderDao();
    }

    @Test
    public void testSaveOrder() throws ParseException, SQLException {

        String id = "ORDERID";
        Date now = new Date();
        BigDecimal price = new BigDecimal("100.0");
        Integer undelivered = 0;
        Order order = new Order(id, now, price, undelivered, 1);

        assertNotEquals(-1, orderDao.saveOrder(order));
    }

    @Test
    public void testQueryOrdersByUserId() throws ParseException, SQLException {

        int userId = 1;
        List<Order> orders = orderDao.queryOrdersByUserId(userId);

        assertTrue(orders.size() > 0);
    }

    @Test
    public void testQueryOrders() throws ParseException, SQLException {

        List<Order> orders = orderDao.queryOrders();

        assertTrue(orders.size() > 0);
    }

    @Test
    public void testSendOrder() throws ParseException, SQLException {

        String id = "16562817152171";
        Integer status = 1;
        int statusCode = orderDao.changeOrderStatus(id, status);

        assertTrue(statusCode > 0);
    }

    @Test
    public void testAcceptOrder() throws ParseException, SQLException {

        String id = "16562817152171";
        Integer status = 2;
        int statusCode = orderDao.changeOrderStatus(id, status);

        assertTrue(statusCode > 0);
    }

}
