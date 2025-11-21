package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Author;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface AuthorService {

    Iterable<Author> findAll();
}
