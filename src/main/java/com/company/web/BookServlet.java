package com.company.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Book;
import com.company.service.impl.BookService;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookService();

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.queryBooks();

        if (books != null) {

            request.setAttribute("books", books);
            request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
        }
    }

}
