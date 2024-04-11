package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * created by R. Ammon
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
