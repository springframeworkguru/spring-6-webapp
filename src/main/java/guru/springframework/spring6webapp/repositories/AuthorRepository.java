package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Leticia Pillar
 * @project spring-6-webapp
 * @created 2023/03/30 - 8:36 PM
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
