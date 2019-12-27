package Book.dto;

import Book.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book convertDtoToEntity(BookDto bookDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bookDto, Book.class);
    }

    public BookDto convertEntityToDto(Book book) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(book, BookDto.class);
    }
}
