import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}

