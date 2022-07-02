package com.company.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.IBookDao;
import com.company.entity.Book;
import com.company.utils.JDBCUtils;

public class BookDao extends BaseDao implements IBookDao {

    @Override
    public int addBook(Book book) {

        int statusCode = -1;
        String query = "INSERT INTO t_book (name, price, author, sales, stock, img_path) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            statusCode = update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(),
                    book.getStock(),
                    book.getImgPath());

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }

    @Override
    public int deleteBookByID(Integer id) {

        int statusCode = -1;
        String query = "DELETE FROM t_book WHERE id = ?";

        try {
            statusCode = update(query, id);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }

    @Override
    public int updateBook(Book book) {

        int statusCode = -1;
        String query = "UPDATE t_book SET name = ?, price = ?, author = ?, sales = ?, stock = ?, img_path = ? WHERE id = ?";

        try {
            statusCode = update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(),
                    book.getStock(),
                    book.getImgPath(),
                    book.getId());

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return statusCode;
    }

    @Override
    public Book queryBookByID(Integer id) {

        Book book = null;
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book WHERE id = ?";

        try {
            book = queryForOne(Book.class, query, id);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return book;
    }

    @Override
    public List<Book> queryBooks() {

        List<Book> books = new ArrayList<Book>();
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book";

        try {
            books = queryForList(Book.class, query);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return books;
    }

    @Override
    public long getTotalItemSize() {

        long totalSize = 0;
        String query = "SELECT COUNT(*) FROM t_book";

        try {
            totalSize = queryForSingleValue(query);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return totalSize;
    }

    @Override
    public List<Book> getItemsPerPage(int pageNow, int pageSize) {

        List<Book> books = new ArrayList<Book>();
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book LIMIT ?, ?";

        try {
            books = queryForList(Book.class, query, (pageNow - 1) * pageSize, pageSize);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return books;
    }

    @Override
    public long getTotalItemSizeByPrice(BigDecimal min, BigDecimal max) {

        long totalSize = 0;
        String query = "SELECT COUNT(*) FROM t_book WHERE price BETWEEN ? AND ?";

        try {
            totalSize = queryForSingleValue(query, min, max);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return totalSize;
    }

    @Override
    public List<Book> getItemsPerPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max) {

        List<Book> books = new ArrayList<Book>();
        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book WHERE price BETWEEN ? AND ? LIMIT ?, ?";

        try {
            books = queryForList(Book.class, query, min, max, (pageNow - 1) * pageSize, pageSize);

            JDBCUtils.commitAndClose();

        } catch (SQLException e) {
            JDBCUtils.rollbackAndClose();
        }

        return books;
    }

}
