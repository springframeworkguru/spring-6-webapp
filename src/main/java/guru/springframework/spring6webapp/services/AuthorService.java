package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
