package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Book;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BookService {

    Iterable<Book> findAll();

}
