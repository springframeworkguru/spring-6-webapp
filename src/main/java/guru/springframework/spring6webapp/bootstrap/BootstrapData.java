package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.IAuthorRepositroy;
import guru.springframework.spring6webapp.repositories.IBookRepository;
import guru.springframework.spring6webapp.repositories.IPublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // This annotation indicates that this class is a Spring component and will be automatically detected by Spring's component scanning
public class BootstrapData implements CommandLineRunner {

    private final IAuthorRepositroy iAuthorRepositroy;
    private final IBookRepository iBookRepository;
    private final IPublisherRepository iPublisherRepository;

    public BootstrapData(IAuthorRepositroy iAuthorRepositroy, IBookRepository iBookRepository, IPublisherRepository iPublisherRepository) {
        this.iAuthorRepositroy = iAuthorRepositroy;
        this.iBookRepository = iBookRepository;
        this.iPublisherRepository = iPublisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author nabil = new Author(); // Create a new Author object
        nabil.setFirstName("Nabil");
        nabil.setLastName("Boutachrafine");

        Book b_spring_f6 = new Book(); // Create a new Book object
        b_spring_f6.setTitle("Spring Framework 6");
        b_spring_f6.setIsbn("1234567890");

        Publisher springPublisher = new Publisher(); // Create a new Publisher object
        springPublisher.setPublisherName("Spring Books");
        springPublisher.setPublisherAddress("123 Spring St");
        springPublisher.setPublisherCity("Springfield");
        springPublisher.setPublisherState("Spring State");
        springPublisher.setPublisherZip("12345");

        Author savedNabil = iAuthorRepositroy.save(nabil); // Save the Author object to the repository
        Book savedBookSpring6 = iBookRepository.save(b_spring_f6); // Save the Book object to the repository
        Publisher savedSpringPublisher = iPublisherRepository.save(springPublisher); // Save the Publisher object to the repository

        Author tawfiq = new Author();
        tawfiq.setFirstName("Tawfiq");
        tawfiq.setLastName("Boutachrafine");

        Book book_java = new Book();
        book_java.setTitle("Java Programming");
        book_java.setIsbn("0987654321");

        Publisher javaPublisher = new Publisher();
        javaPublisher.setPublisherName("Java Books");
        javaPublisher.setPublisherAddress("456 Java Ave");
        javaPublisher.setPublisherCity("Java City");
        javaPublisher.setPublisherState("Java State");
        javaPublisher.setPublisherZip("67890");

        Author savedTawfiq = iAuthorRepositroy.save(tawfiq); // Save the second Author object
        Book savedBookJava = iBookRepository.save(book_java); // Save the second Book object
        Publisher savedJavaPublisher = iPublisherRepository.save(javaPublisher); // Save the first Publisher object

        savedNabil.getBooks().add(savedBookSpring6); // Add the first book to the first author
        savedTawfiq.getBooks().add(savedBookJava); // Add the second book to the second author
        savedBookSpring6.getAuthors().add(savedNabil); // Add the first author to the first book
        savedBookJava.getAuthors().add(savedTawfiq); // Add the second author to the second book

        savedBookSpring6.setPublisher(savedSpringPublisher); // Set the publisher for the first book
        savedBookJava.setPublisher(savedJavaPublisher); // Set the publisher for the second book

        iAuthorRepositroy.save(savedNabil); // Save the updated first author
        iAuthorRepositroy.save(savedTawfiq); // Save the updated second author
        iBookRepository.save(savedBookSpring6); // Save the updated first book
        iBookRepository.save(savedBookJava); // Save the updated second book

        System.out.println("Bootstrap Data Loaded");
        System.out.println("Number of Authors: " + iAuthorRepositroy.count());
        System.out.println("Number of Books: " + iBookRepository.count());
        System.out.println("Number of Publishers: " + iPublisherRepository.count());
    }
}






