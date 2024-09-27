package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
