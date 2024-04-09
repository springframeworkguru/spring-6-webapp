package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.Domain.Author;
import guru.springframework.spring6webapp.Domain.Book;
import guru.springframework.spring6webapp.Domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
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
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        eric.setFirstName("Rod");
        eric.setLastName("Johnson");

        Book ddd = new Book();
        ddd.setTitle("Domain driven design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        ddd.setTitle("J2EE Development without EJB");
        ddd.setIsbn("54757585");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("Straat");
        publisher.setState("Friesland");
        publisher.setCity("Sneek");
        publisher.setZipCode("8604CZ");
        publisherRepository.save(publisher);

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}



