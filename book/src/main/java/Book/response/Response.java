package Book.response;

import Book.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Response implements IResponse{

    public ResponseEntity<?> returnResponse(int status) {
        switch (status) {
            case 200:
                return ResponseEntity.status(200).body("Success!");
            case 201:
                return ResponseEntity.status(201).body("Created!");
            case 404:
                return ResponseEntity.status(404).body("Book not exist!");
            case 500:
                return ResponseEntity.status(500).body("System error!");
            default:
                return null;
        }
    }

    public ResponseEntity<?> returnResponse(int status, List<?> data) {
        switch (status) {
            case 200:
                return ResponseEntity.status(200).body(data);
            default:
                return null;
        }
    }

    public ResponseEntity<?> returnResponse(int status, Page<?> data) {
        switch (status) {
            case 200:
                return ResponseEntity.status(200).body(data);
            default:
                return null;
        }
    }

    public ResponseEntity<?> returnResponse(int status, BookDto data) {
        switch (status) {
            case 200:
                return ResponseEntity.status(200).body(data);
            default:
                return null;
        }
    }

}
