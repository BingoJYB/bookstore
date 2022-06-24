package test.com.company.dao;

import com.company.dao.impl.OrderDao;
import com.company.entity.Order;
import com.company.entity.OrderItem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderDaoTest {

    private OrderDao orderDao;

    @BeforeEach
    void setUp() {

        orderDao = new OrderDao();
    }

    @Test
    public void testSaveOrder() throws ParseException {

        Date now = new Date();
        BigDecimal price = new BigDecimal("100.0");
        Integer undelivered = 0;
        Order order = new Order(null, now, price, undelivered, 1);

        assertNotEquals(-1, orderDao.saveOrder(order));
    }

    @Test
    public void testSaveOrderItem() {

        String name = "105 Men and 3 Women Story";
        Integer count = 2;
        BigDecimal price = new BigDecimal("50.0");
        BigDecimal totalPrice = new BigDecimal("100.0");
        OrderItem orderItem = new OrderItem(null, name, count, price, totalPrice, 1);

        assertNotEquals(-1, orderDao.saveOrderItem(orderItem));
    }

}
