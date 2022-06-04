package com.company.dao;

import java.util.List;

import com.company.entity.Book;

public interface IBookDao {

    public int addBook(Book book);

    public int deleteBookByID(Integer id);

    public int updateBook(Book book);

    public Book queryBookByID(Integer id);

    public List<Book> queryBooks();
}
