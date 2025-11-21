package guru.springframework.spring7webapp.repositories;

import guru.springframework.spring7webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
