package com.company.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.company.entity.Book;
import com.company.entity.Page;

public interface IBookService {

    public int addBook(Book book) throws SQLException;

    public int deleteBookByID(Integer id) throws SQLException;

    public int updateBook(Book book) throws SQLException;

    public Book queryBookByID(Integer id) throws SQLException;

    public List<Book> queryBooks() throws SQLException;

    public Page getPage(int pageNow, int pageSize) throws SQLException;

    public Page getPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max) throws SQLException;

    public int getTotalPageSize(int pageSize) throws SQLException;

}
