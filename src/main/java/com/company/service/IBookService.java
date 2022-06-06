package com.company.service;

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

}
