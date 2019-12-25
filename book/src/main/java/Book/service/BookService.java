package Book.service;

import Book.dto.BookDto;
import Book.model.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> findById(Integer id);
    List<BookDto> getAllByCategory();
}
