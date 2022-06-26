package test.com.company.service;

import com.company.entity.Cart;
import com.company.entity.CartItem;
import com.company.service.impl.OrderService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

public class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {

        orderService = new OrderService();
    }

    @Test
    public void testCreateOrder() {

        CartItem item1 = new CartItem(null, "Harry Potter", 1, new BigDecimal(10.0));
        CartItem item2 = new CartItem(null, "King Lion", 2, new BigDecimal(20.0));
        CartItem item3 = new CartItem(null, "Star Killer", 3, new BigDecimal(30.0));

        Cart cart = new Cart();

        cart.addItem(item1, 1);
        cart.addItem(item2, 2);
        cart.addItem(item3, 3);

        int returnCode = orderService.createOrder(cart, 1);

        assertTrue(returnCode > 0);
    }

}
