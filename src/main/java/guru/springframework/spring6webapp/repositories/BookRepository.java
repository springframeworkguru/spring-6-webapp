package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author tmekaumput @Date 30/3/24 3:24 pm
 */
public interface BookRepository extends CrudRepository<Book, Long> {}
