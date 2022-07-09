package com.company.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.IBookDao;
import com.company.entity.Book;

public class BookDao extends BaseDao implements IBookDao {

    @Override
    public int addBook(Book book) throws SQLException {

        int statusCode = -1;
        String query = "INSERT INTO t_book (name, price, author, sales, stock, img_path) VALUES (?, ?, ?, ?, ?, ?)";

        statusCode = update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(),
                book.getStock(),
                book.getImgPath());

        return statusCode;
    }

    @Override
    public int deleteBookByID(Integer id) throws SQLException {

        int statusCode = -1;
        String query = "DELETE FROM t_book WHERE id = ?";

        statusCode = update(query, id);

        return statusCode;
    }

    @Override
    public int updateBook(Book book) throws SQLException {

        int statusCode = -1;
        String query = "UPDATE t_book SET name = ?, price = ?, author = ?, sales = ?, stock = ?, img_path = ? WHERE id = ?";

        statusCode = update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(),
                book.getStock(),
                book.getImgPath(),
                book.getId());

        return statusCode;
    }

    @Override
    public Book queryBookByID(Integer id) throws SQLException {

        Book book = null;
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book WHERE id = ?";

        book = queryForOne(Book.class, query, id);

        return book;
    }

    @Override
    public List<Book> queryBooks() throws SQLException {

        List<Book> books = new ArrayList<Book>();
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book";

        books = queryForList(Book.class, query);

        return books;
    }

    @Override
    public long getTotalItemSize() throws SQLException {

        long totalSize = 0;
        String query = "SELECT COUNT(*) FROM t_book";

        totalSize = queryForSingleValue(query);

        return totalSize;
    }

    @Override
    public List<Book> getItemsPerPage(int pageNow, int pageSize) throws SQLException {

        List<Book> books = new ArrayList<Book>();
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book LIMIT ?, ?";

        books = queryForList(Book.class, query, (pageNow - 1) * pageSize, pageSize);

        return books;
    }

    @Override
    public long getTotalItemSizeByPrice(BigDecimal min, BigDecimal max) throws SQLException {

        long totalSize = 0;
        String query = "SELECT COUNT(*) FROM t_book WHERE price BETWEEN ? AND ?";

        totalSize = queryForSingleValue(query, min, max);

        return totalSize;
    }

    @Override
    public List<Book> getItemsPerPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max)
            throws SQLException {

        List<Book> books = new ArrayList<Book>();
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book WHERE price BETWEEN ? AND ? LIMIT ?, ?";

        books = queryForList(Book.class, query, min, max, (pageNow - 1) * pageSize, pageSize);

        return books;
    }

}
