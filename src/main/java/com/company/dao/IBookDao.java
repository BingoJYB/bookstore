package com.company.dao;

import java.math.BigDecimal;
import java.util.List;

import com.company.entity.Book;

public interface IBookDao {

    public int addBook(Book book);

    public int deleteBookByID(Integer id);

    public int updateBook(Book book);

    public Book queryBookByID(Integer id);

    public List<Book> queryBooks();

    public long getTotalItemSize();

    public List<Book> getItemsPerPage(int pageNow, int pageSize);

    public long getTotalItemSizeByPrice(BigDecimal min, BigDecimal max);

    public List<Book> getItemsPerPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max);
}
