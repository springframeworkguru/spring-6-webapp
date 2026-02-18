package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Author;

public interface AuthorService {

    public Iterable<Author> findAll();

}
