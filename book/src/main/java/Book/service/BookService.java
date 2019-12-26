package Book.service;

import Book.model.Book;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Optional<Book> findById(Integer id);
    List<Book> findByName(String title);
    List<Book> findByCategoryId(Integer id);
    Boolean addOrUpdateBook(Book book);
    Boolean deleteBook(Integer id);
}
