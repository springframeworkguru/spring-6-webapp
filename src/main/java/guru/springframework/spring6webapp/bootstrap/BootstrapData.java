package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
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
        // Save some sample authors and books
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("654321");

        Publisher penguin = new Publisher();
        penguin.setPublisherName( "Penguin Books");
        penguin.setAddress("123 Main St");
        penguin.setCity("Philadelphia");
        penguin.setState("Pennsylvania");
        penguin.setZipCode("19146");

        Publisher macmillan = new Publisher();
        macmillan.setPublisherName( "Macmillan Publishing");
        macmillan.setAddress("456 Side St");
        macmillan.setCity("London");
        macmillan.setState("London");
        macmillan.setZipCode("W1T 4TJ");

        // Save the authors and books
        Author ericSaved = authorRepository.save(eric);
        Author rodSaved = authorRepository.save(rod);
        Book dddSaved = bookRepository.save(ddd);
        Book noEJBSaved = bookRepository.save(noEJB);
        Publisher penguinSaved = publisherRepository.save(penguin);
        Publisher macmillanSaved = publisherRepository.save(macmillan);


        // Add relationships (call a collection, add a relationship to it, save to repository)
        ericSaved.getBooks().add(dddSaved);
        authorRepository.save(ericSaved);
        rodSaved.getBooks().add(noEJBSaved);
        authorRepository.save(rodSaved);

        penguinSaved.getBooks().add(dddSaved);
        publisherRepository.save(penguinSaved);
        macmillanSaved.getBooks().add(noEJBSaved);
        publisherRepository.save(macmillanSaved);

        dddSaved.getAuthors().add(ericSaved);
        dddSaved.setPublisher(penguinSaved);
        bookRepository.save(dddSaved);
        noEJBSaved.getAuthors().add(rodSaved);
        noEJBSaved.setPublisher(macmillanSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Authors Count: " + authorRepository.count());
        System.out.println("Books Count: " + bookRepository.count());
        System.out.println("Publishers Count: " + publisherRepository.count());
        System.out.println(dddSaved.getTitle() + ": " + dddSaved.getAuthors().stream().findFirst().map(Author::getLastName).orElse("Unknown"));
        System.out.println(noEJBSaved.getTitle() + ": " + noEJBSaved.getAuthors().stream().findFirst().map(Author::getLastName).orElse("Unknown"));
    }
}
