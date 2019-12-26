package Book.service.impl;

import Book.model.Book;
import Book.repository.BookRepository;
import Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
            return bookRepository.findById(id);
    }

    @Override
    public List<Book> findByName(String title) {
        return bookRepository.findByName(title);
    }

    @Override
    public List<Book> findByCategoryId(Integer id) {
        return null;
    }

    @Override
    public Boolean addOrUpdateBook(Book book) {
        try {
            bookRepository.save(book);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else return false;
    }
}