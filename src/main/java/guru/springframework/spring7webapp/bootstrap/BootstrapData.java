package guru.springframework.spring7webapp.bootstrap;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.domain.Publisher;
import guru.springframework.spring7webapp.repositories.AuthorRepository;
import guru.springframework.spring7webapp.repositories.BookRepository;
import guru.springframework.spring7webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author joop = new Author();
        joop.setFirstName("Joop");
        joop.setLastName("Appelstroop");

        Book ddd = new Book();
        ddd.setTitle("DomainDrivenDesign");
        ddd.setIsbn("123128384");

        Author joopSaved = authorRepository.save(joop);
        Book dddSaved = bookRepository.save(ddd);

        Author piet = new Author();
        piet.setFirstName("Piet");
        piet.setLastName("Vergeetmijniet");

        Book edd = new Book();
        edd.setTitle("Event Driven Design");
        edd.setIsbn("01293434597");

        Author pietSaved = authorRepository.save(piet);
        Book eddSaved = bookRepository.save(edd);

        Publisher publisher = new Publisher();
        publisher.setAddress("teststreet 26");
        publisher.setCity("New York");
        publisher.setState("New York");
        publisher.setPublisherName("El publicity");

        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        eddSaved.setPublisher(savedPublisher);

        Book test = bookRepository.save(eddSaved);
        Book test2 = bookRepository.save(dddSaved);
        authorRepository.save(joopSaved);
        authorRepository.save(pietSaved);

        System.out.println("Authors count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());

        System.out.println("Publisher count: " + test.getPublisher().getPublisherName());
        System.out.println("Publisher count: " + test2.getPublisher().getPublisherName());
    }
}
