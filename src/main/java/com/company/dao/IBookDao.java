package com.company.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.company.entity.Book;

public interface IBookDao {

    public int addBook(Book book) throws SQLException;

    public int deleteBookByID(Integer id) throws SQLException;

    public int updateBook(Book book) throws SQLException;

    public Book queryBookByID(Integer id) throws SQLException;

    public List<Book> queryBooks() throws SQLException;

    public long getTotalItemSize() throws SQLException;

    public List<Book> getItemsPerPage(int pageNow, int pageSize) throws SQLException;

    public long getTotalItemSizeByPrice(BigDecimal min, BigDecimal max) throws SQLException;

    public List<Book> getItemsPerPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max) throws SQLException;
}
