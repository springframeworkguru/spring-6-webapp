package guru.springframework.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring6webapp.domain.Book;

public interface IBookRepository extends CrudRepository<Book, Long> {





}
