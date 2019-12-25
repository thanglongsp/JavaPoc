package Book.service.impl;

import Book.dto.BookDto;
import Book.model.Book;
import Book.repository.BookRepository;
import Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findById(Integer id) {
        return null;
    }

    @Override
    public List<BookDto> getAllByCategory() {
        return bookRepository.getAllByCategory();
    }
}