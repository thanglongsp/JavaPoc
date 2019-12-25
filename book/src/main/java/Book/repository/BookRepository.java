package Book.repository;

import Book.dto.BookDto;
import Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.title, b.book_id, c.description FROM book b inner join category c on b.category = c.id", nativeQuery = true)
    List<BookDto>getAllByCategory();
}
