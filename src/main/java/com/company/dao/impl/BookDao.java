package com.company.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.company.dao.IBookDao;
import com.company.entity.Book;

public class BookDao extends BaseDao implements IBookDao {

    @Override
    public int addBook(Book book) {

        String query = "INSERT INTO t_book (name, price, author, sales, stock, img_path) VALUES (?, ?, ?, ?, ?, ?)";

        return update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(),
                book.getImgPath());
    }

    @Override
    public int deleteBookByID(Integer id) {

        String query = "DELETE FROM t_book WHERE id = ?";

        return update(query, id);
    }

    @Override
    public int updateBook(Book book) {

        String query = "UPDATE t_book SET name = ?, price = ?, author = ?, sales = ?, stock = ?, img_path = ? WHERE id = ?";

        return update(query, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(),
                book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookByID(Integer id) {

        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book WHERE id = ?";

        return queryForOne(Book.class, query, id);
    }

    @Override
    public List<Book> queryBooks() {

        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book";

        return queryForList(Book.class, query);
    }

    @Override
    public long getTotalItemSize() {

        String query = "SELECT COUNT(*) FROM t_book";

        return queryForSingleValue(query);
    }

    @Override
    public List<Book> getItemsPerPage(int pageNow, int pageSize) {

        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book LIMIT ?, ?";

        return queryForList(Book.class, query, (pageNow - 1) * pageSize, pageSize);
    }

    @Override
    public long getTotalItemSizeByPrice(BigDecimal min, BigDecimal max) {

        String query = "SELECT COUNT(*) FROM t_book WHERE price BETWEEN ? AND ?";

        return queryForSingleValue(query, min, max);
    }

    @Override
    public List<Book> getItemsPerPageByPrice(int pageNow, int pageSize, BigDecimal min, BigDecimal max) {

        String query = "SELECT id, name, price, author, sales, stock, img_path imgPath FROM t_book WHERE price BETWEEN ? AND ? LIMIT ?, ?";

        return queryForList(Book.class, query, min, max, (pageNow - 1) * pageSize, pageSize);
    }

}
