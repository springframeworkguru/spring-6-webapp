package guru.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Author;

public interface IAuthorRepository extends CrudRepository<Author, Long> {



}
