package guru.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Publisher;

public interface IPublischerRepository extends CrudRepository<Publisher, Long> {
}
