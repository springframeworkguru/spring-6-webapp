package guru.springframework.spring7webapp.services;

import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookserviceImpl implements Bookservice {

    private final BookRepository bookRepository;

    public BookserviceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
