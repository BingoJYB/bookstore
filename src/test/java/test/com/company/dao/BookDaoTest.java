package test.com.company.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.company.dao.impl.BookDao;
import com.company.entity.Book;

public class BookDaoTest {

    private BookDao bookDao;

    @BeforeEach
    void setUp() {

        bookDao = new BookDao();
    }

    @Test
    public void testAddBook() throws SQLException {

        Book book = new Book(null, "Sample", new BigDecimal(100.00), "Stephen Hawking", 0, 20, null);

        assertNotEquals(-1, bookDao.addBook(book));
    }

    @Test
    public void testUpdateBook() throws SQLException {

        Book book = new Book(1, "Sample", new BigDecimal(100.00), "Stephen Hawking", 10, 10, null);

        assertNotEquals(-1, bookDao.updateBook(book));
    }

    @Test
    public void testQueryBookByID() throws SQLException {

        Book book = bookDao.queryBookByID(1);

        assertEquals("Sample Book", book.getName());
    }

    @Test
    public void testQueryBooks() throws SQLException {

        List<Book> books = bookDao.queryBooks();

        assertTrue(books.size() > 0);
    }

    @Test
    public void testGetTotalItemSize() throws SQLException {

        assertEquals(1, bookDao.getTotalItemSize());
    }

    @Test
    public void testGetItemsPerPage() throws SQLException {

        List<Book> books = bookDao.getItemsPerPage(1, 1);
        assertEquals(1, books.size());
    }

    @Test
    public void testGetTotalItemSizeByPrice() throws SQLException {

        assertEquals(2, bookDao.getTotalItemSizeByPrice(new BigDecimal(1.0), new BigDecimal(20.0)));
    }

    @Test
    public void testGetItemsPerPageByPrice() throws SQLException {

        List<Book> books = bookDao.getItemsPerPageByPrice(1, 2, new BigDecimal(1.0), new BigDecimal(20.0));
        assertEquals(2, books.size());
    }

    @Test
    public void testDeleteBookByID() throws SQLException {

        assertNotEquals(-1, bookDao.deleteBookByID(1));
    }
}
