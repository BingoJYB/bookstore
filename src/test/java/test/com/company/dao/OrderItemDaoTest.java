package test.com.company.dao;

import com.company.dao.impl.OrderItemDao;
import com.company.entity.OrderItem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderItemDaoTest {

    private OrderItemDao orderItemDao;

    @BeforeEach
    void setUp() {

        orderItemDao = new OrderItemDao();
    }

    @Test
    public void testSaveOrderItem() throws SQLException {

        String name = "105 Men and 3 Women Story";
        Integer count = 2;
        BigDecimal price = new BigDecimal("50.0");
        BigDecimal totalPrice = new BigDecimal("100.0");
        String orderId = "ORDERID";
        OrderItem orderItem = new OrderItem(null, name, count, price, totalPrice, orderId);

        assertNotEquals(-1, orderItemDao.saveOrderItem(orderItem));
    }

    @Test
    public void testQueryOrderItemsByOrderId() throws SQLException {

        String id = "16562817152171";
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId(id);

        assertTrue(orderItems.size() > 0);
    }

}
