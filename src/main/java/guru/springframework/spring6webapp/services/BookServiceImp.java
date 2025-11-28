package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.IBookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements IBookService{

    private final IBookRepository iBookRepository;

    public BookServiceImp(IBookRepository bookRepository) {
        this.iBookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAllBooks() { // Implementation to retrieve all books from the database
        return iBookRepository.findAll();
    }
}
