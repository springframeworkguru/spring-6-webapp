package guru.springframework.spring7webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
