package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.IBookRepository;

@Service
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
