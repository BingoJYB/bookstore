package com.company.service;

import java.math.BigDecimal;
import java.util.List;

import com.company.entity.Book;
import com.company.entity.Page;

public interface IBookService {

    public int addBook(Book book);

    public int deleteBookByID(Integer id);

    public int updateBook(Book book);

    public Book queryBookByID(Integer id);

    public List<Book> queryBooks();

    public Page getPage(int pageNow, int pageSize);

    public Page getPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max);

}
