package Book.service;

import Book.dto.BookDto;
import Book.model.Book;
import org.springframework.data.domain.Page;
import java.util.List;

public interface BookService {
    Page<Book> findAll(Integer page);
    BookDto findById(Integer id);
    List<Book> findByName(String title);
    List<Book> findByCategoryId(Integer id);
    Boolean addOrUpdateBook(BookDto bookDto);
    Boolean deleteBook(Integer id);
    Boolean deleteByCategory(int id);
}
