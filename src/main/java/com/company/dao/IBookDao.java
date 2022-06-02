package com.company.dao;

import java.util.List;

import com.company.entity.Book;

public interface IBookDao {

    public void addBook(Book book);

    public void deleteBookByID(Integer id);

    public void updateBook(Book book);

    public Book queryBookByID(Integer id);

    public List<Book> queryBook();
}
