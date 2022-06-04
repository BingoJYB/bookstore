package com.company.service.impl;

import java.util.List;

import com.company.dao.impl.BookDao;
import com.company.entity.Book;
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

}
