import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Ваша задача написать unit-тесты для BookService,
 * используя Mockito для создания мок-объекта BookRepository.
 */

public class BookServiceTest {
    BookRepository bookRepositoryMock = mock(BookRepository.class);
    BookRepository bookRepositoryStub;

    @BeforeEach
    void setUp() {
        bookRepositoryStub = new InMemoryBookRepository();
    }

    @AfterEach
    void tearDown() {
        bookRepositoryStub = null;
    }

    @Test
    @DisplayName("search by id test")
    void findBookById() {
        Book test = bookRepositoryMock.findById("1");
        verify(bookRepositoryMock).findById("1");

        test = new Book("1", "Book1", "Author1");
        assertEquals(test, bookRepositoryStub.findById("1"));

    }

    @Test
    @DisplayName("test find all books")
    void findAllBooks() {
        List<Book> books = bookRepositoryMock.findAll();
        verify(bookRepositoryMock).findAll();

        List<Book> list = Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2"));
        assertArrayEquals(list.toArray(), bookRepositoryStub.findAll().toArray());

    }

}