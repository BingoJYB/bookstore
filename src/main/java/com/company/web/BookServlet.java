package com.company.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Book;
import com.company.service.impl.BookService;
import com.company.utils.WebUtils;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookService();

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Book> books = bookService.queryBooks();

        if (books != null) {

            request.setAttribute("books", books);
            request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
        }
    }

    public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = new Book();
        WebUtils.mapParam2Bean(request, book);

        int returnCode = bookService.addBook(book);

        if (returnCode != -1) {

            response.sendRedirect(request.getContextPath() + "/manager/BookServlet?method=list");
        }
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        int returnCode = bookService.deleteBookByID(id);

        if (returnCode != -1) {

            response.sendRedirect(request.getContextPath() + "/manager/BookServlet?method=list");
        }
    }

    public void getBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));

        Book book = bookService.queryBookByID(id);

        if (book != null) {

            request.setAttribute("book", book);
            request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
        }
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Book book = new Book();
        WebUtils.mapParam2Bean(request, book);
        Integer id = Integer.parseInt(request.getParameter("id"));

        int returnCode = bookService.updateBook(book);

        if (returnCode != -1) {

            response.sendRedirect(request.getContextPath() + "/manager/BookServlet?method=list");
        }
    }

}
