package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.Domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
