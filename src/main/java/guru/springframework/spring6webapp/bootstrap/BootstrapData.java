package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.IAuthorRepositroy;
import guru.springframework.spring6webapp.repositories.IBookRepository;
import guru.springframework.spring6webapp.repositories.IPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // This annotation indicates that this class is a Spring component and will be automatically detected by Spring's component scanning
public class BootstrapData implements CommandLineRunner {

    private final IAuthorRepositroy iAuthorRepositroy;
    private final IBookRepository iBookRepository;
    private final IPublisher iPublisher;

    public BootstrapData(IAuthorRepositroy iAuthorRepositroy, IBookRepository iBookRepository, IPublisher iPublisher) {
        this.iAuthorRepositroy = iAuthorRepositroy;
        this.iBookRepository = iBookRepository;
        this.iPublisher = iPublisher;
    }


    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("Nabil");
        author1.setLastName("Boutachrafine");

        Book book1 = new Book();
        book1.setTitle("Spring Framework 6");
        book1.setIsbn("1234567890");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Spring Books Publishing");
        publisher.setPublisherAddress("123 Spring St");
        publisher.setPublisherCity("Springfield");
        publisher.setPublisherState("Spring State");
        publisher.setPublisherZip("12345");

        Author authorSaved1 = iAuthorRepositroy.save(author1);
        Book bookSaved1 = iBookRepository.save(book1);
        Publisher publisherSaved = iPublisher.save(publisher);

        Author author2 = new  Author();
        author2.setFirstName("Tawfiq");
        author2.setLastName("Boutachrafine");

        Book book2 = new Book();
        book2.setTitle("Spring Boot 3");
        book2.setIsbn("0987654321");

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Spring Boot Books Publishing");
        publisher2.setPublisherAddress("456 Spring Boot St");
        publisher2.setPublisherCity("Spring Boot City");
        publisher2.setPublisherState("Spring Boot State");
        publisher2.setPublisherZip("54321");

        Author authorSaved2 = iAuthorRepositroy.save(author2);
        Book bookSaved2 = iBookRepository.save(book2);
        Publisher publisherSaved2 = iPublisher.save(publisher2);

        authorSaved1.getBooks().add(bookSaved1);
        authorSaved2.getBooks().add(bookSaved2);

        iAuthorRepositroy.save(authorSaved1);
        iAuthorRepositroy.save(authorSaved2);

        System.out.println("Bootstrap Data Loaded");
        System.out.println("Number of Authors: " + iAuthorRepositroy.count());
        System.out.println("Number of Books: " + iBookRepository.count());
        System.out.println("Number of Publishers: " + iPublisher.count());
    }
}






