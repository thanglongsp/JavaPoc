package Book.controller;

import Book.dto.BookDto;
import Book.model.Book;
import Book.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/book")
public class RestBookController {
    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/")
    public List<BookDto> findAll() {
        return bookService.getAllByCategory();
    }
}

