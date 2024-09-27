package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BookService {

    Iterable<Book> findAll();

}
