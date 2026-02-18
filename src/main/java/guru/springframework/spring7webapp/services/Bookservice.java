package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Book;

public interface Bookservice {
    public Iterable<Book> findAll();
}
