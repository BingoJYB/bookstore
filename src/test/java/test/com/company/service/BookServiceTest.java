package test.com.company.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.company.entity.Book;
import com.company.entity.Page;
import com.company.service.impl.BookService;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {

        bookService = new BookService();
    }

    @Test
    public void testAddBook() throws SQLException {

        Book book = new Book(null, "Sample Book", new BigDecimal(100.00), "Stephen Hawking", 0, 20, null);

        assertNotEquals(-1, bookService.addBook(book));
    }

    @Test
    public void testUpdateBook() throws SQLException {

        Book book = new Book(1, "Sample Book", new BigDecimal(100.00), "Stephen Hawking", 10, 10, null);

        assertNotEquals(-1, bookService.updateBook(book));
    }

    @Test
    public void testQueryBookByID() throws SQLException {

        Book book = bookService.queryBookByID(1);

        assertEquals("Sample Book", book.getName());
    }

    @Test
    public void testQueryBooks() throws SQLException {

        List<Book> books = bookService.queryBooks();

        assertTrue(books.size() > 0);
    }

    @Test
    public void testGetPage() throws SQLException {

        Page page = bookService.getPage(1, 1);

        assertEquals(5, page.getTotalCount());
        assertEquals(5, page.getTotalPages());
    }

    @Test
    public void testGetPageByPrice() throws SQLException {

        Page page = bookService.getPageByPrice(1, 1, new BigDecimal(1.0), new BigDecimal(20.0));

        assertEquals(2, page.getTotalCount());
        assertEquals(2, page.getTotalPages());
    }

    @Test
    public void testDeleteBookByID() throws SQLException {

        assertNotEquals(-1, bookService.deleteBookByID(1));
    }
}
