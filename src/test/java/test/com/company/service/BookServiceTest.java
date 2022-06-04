package test.com.company.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import com.company.entity.Book;
import com.company.service.impl.BookService;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {

        bookService = new BookService();
    }

    @Test
    public void testAddBook() {

        Book book = new Book(null, "Sample Book", new BigDecimal(100.00), "Stephen Hawking", 0, 20, null);

        assertNotEquals(-1, bookService.addBook(book));
    }

    @Test
    public void testUpdateBook() {

        Book book = new Book(1, "Sample Book", new BigDecimal(100.00), "Stephen Hawking", 10, 10, null);

        assertNotEquals(-1, bookService.updateBook(book));
    }

    @Test
    public void testQueryBookByID() {

        Book book = bookService.queryBookByID(1);

        assertEquals("Sample Book", book.getName());
    }

    @Test
    public void testQueryBooks() {

        List<Book> books = bookService.queryBooks();

        assertTrue(books.size() > 0);
    }

    @Test
    public void testDeleteBookByID() {

        assertNotEquals(-1, bookService.deleteBookByID(1));
    }
}
