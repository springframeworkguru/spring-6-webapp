package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author tmekaumput
 * @Date 30/3/24 12:58 pm
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {}
