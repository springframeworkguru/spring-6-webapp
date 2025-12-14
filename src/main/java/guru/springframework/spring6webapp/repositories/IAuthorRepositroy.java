package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepositroy extends CrudRepository<Author, Long> {

}
