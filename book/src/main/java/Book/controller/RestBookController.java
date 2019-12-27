package Book.controller;

import Book.dto.BookDto;
import Book.dto.BookMapper;
import Book.model.Book;
import Book.repository.BookRepository;
import Book.response.Response;
import Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/book")
public class RestBookController {
    @Autowired
    BookService bookService;

    @Autowired
    BookRepository repository;

    @Autowired
    Response response;

    @GetMapping("/page={page}")
    public ResponseEntity<?> findAll(@PathVariable("page") int page) {
        Page<Book> listBook;
        try {
            listBook = bookService.findAll(page);
            return response.returnResponse(200, listBook);
        } catch (Exception e) {
            return response.returnResponse(500);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        BookDto bookDto;
        if (repository.existsById(id)) {
            try {
                bookDto = bookService.findById(id);
                return response.returnResponse(200, bookDto);
            } catch (Exception e) {
                return response.returnResponse(500);
            }
        } else {
            return response.returnResponse(404);
        }
    }

    @GetMapping("/title={title}")
    public ResponseEntity<?> findByName(@PathVariable("title") String title) {
        List<Book> listBook;
        try {
            listBook = bookService.findByName(title);
            return response.returnResponse(200, listBook);
        } catch (Exception e) {
            return response.returnResponse(500);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestParam("title") String title, @RequestParam("category") int category) {
        try {
            BookDto bookDto = new BookDto();
            bookDto.setCategory(category);
            bookDto.setTitle(title);

            if (bookService.addOrUpdateBook(bookDto))
                return response.returnResponse(201);
            else throw new Exception();
        } catch (Exception e) {
            return response.returnResponse(500);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateBook(@RequestParam("id") Integer id, @RequestParam("title") String title, @RequestParam("category") int category) {
        BookMapper bookMapper = new BookMapper();
        try {
            BookDto bookDto = bookMapper.convertEntityToDto(repository.findById(id).get());
            if (!title.equals("")) bookDto.setTitle(title);
            if (category != 0) bookDto.setCategory(category);
            if (bookService.addOrUpdateBook(bookDto))
                return response.returnResponse(200);
            else throw new Exception();
        } catch (Exception e) {
            return response.returnResponse(500);
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (repository.existsById(id)) {
            try {
                if (bookService.deleteBook(id))
                    return response.returnResponse(200);
                else throw new Exception();
            } catch (Exception e) {
                return response.returnResponse(500);
            }
        } else
            return response.returnResponse(500);
    }
}

