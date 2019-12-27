package Book.response;

import Book.dto.BookDto;
import Book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IResponse {
    ResponseEntity<?> returnResponse(int status);
    ResponseEntity<?> returnResponse(int status, List<?> data);
    ResponseEntity<?> returnResponse(int status, Page<?> data);
    ResponseEntity<?> returnResponse(int status, BookDto data);
}
