package Book.repository;

import Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b.title as title, b.book_id as id, c.description as description FROM book b inner join category c on b.category = c.id", nativeQuery = true)
    List<Book>getAllByCategory();

    @Query("SELECT b FROM Book b WHERE b.title like %:title%")
    List<Book>findByName(@Param("title") String title);

    @Query(value = "SELECT b.title as title, b.book_id as id, c.description as description FROM book b inner join category c on b.category = c.id", nativeQuery = true)
    List<Book>findByCategoryType();
}