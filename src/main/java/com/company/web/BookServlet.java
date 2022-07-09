package com.company.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.entity.Book;
import com.company.entity.Page;
import com.company.service.impl.BookService;
import com.company.utils.Constants;
import com.company.utils.JDBCUtils;
import com.company.utils.WebUtils;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookService();

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Book> books = bookService.queryBooks();

            if (books != null) {
                request.setAttribute("books", books);
                request.getRequestDispatcher("BookServlet?method=getAllManagerAfter&pageNow="
                        + bookService.getTotalPageSize(Constants.DEFAULT_PAGE_SIZE)).forward(request, response);
            }

            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }
    }

    public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int returnCode = -1;
        Book book = new Book();
        WebUtils.mapParam2Bean(request, book);

        try {
            returnCode = bookService.addBook(book);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/BookServlet?method=list");
        }
    }

    public void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int returnCode = -1;
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            returnCode = bookService.deleteBookByID(id);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/BookServlet?method=list");
        }
    }

    public void getBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Book book = null;
        Integer id = Integer.parseInt(request.getParameter("id"));

        try {
            book = bookService.queryBookByID(id);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (book != null) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
        }
    }

    public void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int returnCode = -1;
        Book book = new Book();
        WebUtils.mapParam2Bean(request, book);

        try {
            returnCode = bookService.updateBook(book);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (returnCode != -1) {
            response.sendRedirect(request.getContextPath() + "/BookServlet?method=list");
        }
    }

    public void getAllManagerAfter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Page page = null;
        Integer pageNow = WebUtils.parseInt(request.getParameter("pageNow"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Constants.DEFAULT_PAGE_SIZE);

        try {
            page = bookService.getPage(pageNow, pageSize);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (page != null) {
            request.setAttribute("page", page);
            request.setAttribute("url", Constants.MANAGER_PAGING_URL);
            request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
        }
    }

    public void getAllHomeAfter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Page page = null;
        Integer pageNow = WebUtils.parseInt(request.getParameter("pageNow"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Constants.DEFAULT_PAGE_SIZE);

        try {
            page = bookService.getPage(pageNow, pageSize);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        if (page != null) {
            request.setAttribute("page", page);
        }

        request.setAttribute("url", Constants.HOME_PAGING_URL);
        request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
    }

    public void getAllHomeByPrice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Page page = null;
        BigDecimal min;
        BigDecimal max;

        Integer pageNow = WebUtils.parseInt(request.getParameter("pageNow"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Constants.DEFAULT_PAGE_SIZE);
        String minStr = request.getParameter("min");
        String maxStr = request.getParameter("max");

        if (minStr.isEmpty()) {
            min = new BigDecimal(0.0);
        } else {
            min = new BigDecimal(minStr);
        }

        if (maxStr.isEmpty()) {
            max = new BigDecimal(Integer.MAX_VALUE);
        } else {
            max = new BigDecimal(maxStr);
        }

        try {
            page = bookService.getPageByPrice(pageNow, pageSize, min, max);
            JDBCUtils.commitAndClose();
        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }
        
        StringBuilder enhancedUrl = new StringBuilder(Constants.HOME_PAGING_BY_PRICE_URL);
        enhancedUrl.append("&min=").append(min.toString());
        enhancedUrl.append("&max=").append(max.toString());

        if (page != null) {
            request.setAttribute("page", page);
            request.setAttribute("url", enhancedUrl.toString());
            request.getRequestDispatcher("/pages/user/home.jsp").forward(request, response);
        }
    }

}
