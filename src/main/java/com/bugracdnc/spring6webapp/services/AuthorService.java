package com.bugracdnc.spring6webapp.services;

import com.bugracdnc.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
