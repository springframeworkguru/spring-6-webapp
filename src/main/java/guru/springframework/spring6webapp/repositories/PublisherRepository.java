package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Leticia Pillar
 * @project spring-6-webapp
 * @created 2023/03/31 - 8:30 AM
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
