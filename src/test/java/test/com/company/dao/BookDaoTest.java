package test.com.company.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
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
    public void testAddBook() {

        Book book = new Book(null, "Sample", new BigDecimal(100.00), "Stephen Hawking", 0, 20, null);

        assertNotEquals(-1, bookDao.addBook(book));
    }

    @Test
    public void testUpdateBook() {

        Book book = new Book(1, "Sample", new BigDecimal(100.00), "Stephen Hawking", 10, 10, null);

        assertNotEquals(-1, bookDao.updateBook(book));
    }

    @Test
    public void testQueryBookByID() {

        Book book = bookDao.queryBookByID(1);

        assertEquals("Sample Book", book.getName());
    }

    @Test
    public void testQueryBooks() {

        List<Book> books = bookDao.queryBooks();

        assertTrue(books.size() > 0);
    }

    @Test
    public void testGetTotalItemSize() {

        assertEquals(1, bookDao.getTotalItemSize());
    }

    @Test
    public void testGetItemsPerPage() {

        List<Book> books = bookDao.getItemsPerPage(1, 1);
        assertEquals(1, books.size());
    }

    @Test
    public void testDeleteBookByID() {

        assertNotEquals(-1, bookDao.deleteBookByID(1));
    }
}
