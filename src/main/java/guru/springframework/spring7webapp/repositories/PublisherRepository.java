package guru.springframework.spring7webapp.repositories;

import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
