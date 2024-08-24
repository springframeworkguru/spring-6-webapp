package com.bugracdnc.spring6webapp.bootstrap;

import com.bugracdnc.spring6webapp.domain.Author;
import com.bugracdnc.spring6webapp.domain.Book;
import com.bugracdnc.spring6webapp.domain.Publisher;
import com.bugracdnc.spring6webapp.repositories.AuthorRepository;
import com.bugracdnc.spring6webapp.repositories.BookRepository;
import com.bugracdnc.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Author oguzatay = authorRepository.save(new Author("Oguz", "Atay"));
        Book tutunamayanlar = bookRepository.save(new Book("Tutunamayanlar", "123456"));
        Book tehlikeliOyunlar = bookRepository.save(new Book("Tehlikeli Oyunlar", "123457"));
        Publisher iletisim = publisherRepository.save(new Publisher("Iletisim"));

        tutunamayanlar.setPublisher(iletisim);
        tehlikeliOyunlar.setPublisher(iletisim);

        oguzatay.getBooks().add(tutunamayanlar);
        oguzatay.getBooks().add(tehlikeliOyunlar);
        tutunamayanlar.getAuthors().add(oguzatay);
        tehlikeliOyunlar.getAuthors().add(oguzatay);
        authorRepository.save(oguzatay);
        bookRepository.save(tutunamayanlar);
        bookRepository.save(tehlikeliOyunlar);


        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
