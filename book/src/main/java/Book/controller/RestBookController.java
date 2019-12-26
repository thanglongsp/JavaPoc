package Book.controller;

import Book.model.Book;
import Book.repository.BookRepository;
import Book.response.Response;
import Book.service.BookService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        List<Book> listBook;
        try {
            listBook = bookService.findAll();
            return response.returnResponse(200, listBook);
        } catch (Exception e) {
            return response.returnResponse(500);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        Optional<Book> book;
        if (repository.existsById(id)) {
            try {
                book = bookService.findById(id);
                return response.returnResponse(200, book);
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
            Book book = new Book();
            book.setCategory(category);
            book.setTitle(title);

            if (bookService.addOrUpdateBook(book))
                return response.returnResponse(201);
            else throw new Exception();
        } catch (Exception e) {
            return response.returnResponse(500);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateBook(@RequestParam("id") Integer id, @RequestParam("title") String title, @RequestParam("category") int category) {
        try {
            Book book = repository.findById(id).get();
            if (!title.equals("")) book.setTitle(title);
            if (category != 0) book.setCategory(category);
            if (bookService.addOrUpdateBook(book))
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
                if(bookService.deleteBook(id))
                    return response.returnResponse(200);
                else throw new Exception();
            } catch (Exception e) {
                return response.returnResponse(500);
            }
        } else
            return response.returnResponse(500);
    }
}

