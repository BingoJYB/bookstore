package com.company.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.company.dao.impl.BookDao;
import com.company.entity.Book;
import com.company.entity.Page;
import com.company.service.IBookService;

public class BookService implements IBookService {

    private final BookDao bookDao = new BookDao();

    @Override
    public int addBook(Book book) {

        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookByID(Integer id) {

        return bookDao.deleteBookByID(id);
    }

    @Override
    public int updateBook(Book book) {

        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookByID(Integer id) {

        return bookDao.queryBookByID(id);
    }

    @Override
    public List<Book> queryBooks() {

        return bookDao.queryBooks();
    }

    @Override
    public Page getPage(int pageNow, int pageSize) {

        int totalCount = (int) bookDao.getTotalItemSize();
        int totalPages = (totalCount + pageSize - 1) / pageSize;
        Page page = new Page(pageNow, totalPages, totalCount, pageSize, null);
        page.setItems(bookDao.getItemsPerPage(pageNow, pageSize));

        return page;
    }

    @Override
    public Page getPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max) {

        int totalCount = (int) bookDao.getTotalItemSizeByPrice(min, max);
        int totalPages = (totalCount + pageSize - 1) / pageSize;
        Page page = new Page(pageNow, totalPages, totalCount, pageSize, null);
        page.setItems(bookDao.getItemsPerPageByPrice(pageNow, pageSize, min, max));

        return page;
    }

}
