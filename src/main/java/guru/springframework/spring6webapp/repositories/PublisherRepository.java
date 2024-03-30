package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author tmekaumput
 * @Date 30/3/24 4:22 pm
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {}
