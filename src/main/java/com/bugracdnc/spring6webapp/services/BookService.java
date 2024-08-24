package com.bugracdnc.spring6webapp.services;

import com.bugracdnc.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
