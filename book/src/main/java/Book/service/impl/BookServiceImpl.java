package Book.service.impl;

import Book.dto.BookDto;
import Book.dto.BookMapper;
import Book.model.Book;
import Book.repository.BookRepository;
import Book.service.BookService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Integer page) {
        PageRequest pageable = PageRequest.of(page - 1, 10);
        return bookRepository.findAll(pageable);
    }

    @Override
    public BookDto findById(Integer id) {
        BookMapper bookMapper = new BookMapper();
        return bookMapper.convertEntityToDto(bookRepository.findById(id).get());
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
    public Boolean addOrUpdateBook(BookDto bookDto) {
        BookMapper bookMapper = new BookMapper();
        try {
            bookRepository.save(bookMapper.convertDtoToEntity(bookDto));
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

    @Override
    public Boolean deleteByCategory(int id) {
        bookRepository.deleteByCategory(id);
        return true;
    }
}