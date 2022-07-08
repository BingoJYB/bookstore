package com.company.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Book;
import com.company.entity.Cart;
import com.company.entity.CartItem;
import com.company.service.impl.BookService;
import com.google.gson.Gson;

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookService();

    void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.queryBookByID(id);
        CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addItem(cartItem, id);
        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("items", cart.getItems().values());

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("total", Integer.toString(cart.getTotalCount()));
        hm.put("name", book.getName());

        Gson gson = new Gson();
        String hmInJson = gson.toJson(hm);

        response.getWriter().write(hmInJson);
    }

    void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        cart.deleteItem(id);
        response.sendRedirect(request.getHeader("Referer"));
    }

    void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        cart.clearCart();
        response.sendRedirect(request.getHeader("Referer"));
    }

    void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer count = Integer.parseInt(request.getParameter("count"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        cart.updateCount(id, count);
        request.getSession().setAttribute("cart", cart);
        response.sendRedirect(request.getHeader("Referer"));
    }

    void getItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/cart/cart.jsp").forward(request, response);
    }

}
