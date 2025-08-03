package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.IAuthorRepositroy;
import guru.springframework.spring6webapp.repositories.IBookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // This annotation indicates that this class is a Spring component and will be automatically detected by Spring's component scanning
public class BootstrapData implements CommandLineRunner {

    private final IAuthorRepositroy iAuthorRepositroy;
    private final IBookRepository iBookRepository;

    public BootstrapData(IAuthorRepositroy iAuthorRepositroy, IBookRepository iBookRepository) {
        this.iAuthorRepositroy = iAuthorRepositroy;
        this.iBookRepository = iBookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstName("Nabil");
        author1.setLastName("Boutachrafine");

        Book book1 = new Book();
        book1.setTitle("Spring Framework 6");
        book1.setIsbn("1234567890");

        Author authorSaved1 = iAuthorRepositroy.save(author1);
        Book bookSaved1 = iBookRepository.save(book1);

        Author author2 = new  Author();
        author2.setFirstName("Tawfiq");
        author2.setLastName("Boutachrafine");

        Book book2 = new Book();
        book2.setTitle("Spring Boot 3");
        book2.setIsbn("0987654321");

        Author authorSaved2 = iAuthorRepositroy.save(author2);
        Book bookSaved2 = iBookRepository.save(book2);

        authorSaved1.getBooks().add(bookSaved1);
        authorSaved2.getBooks().add(bookSaved2);

        iAuthorRepositroy.save(authorSaved1);
        iAuthorRepositroy.save(authorSaved2);

        System.out.println("Bootstrap Data Loaded");
        System.out.println("Number of Authors: " + iAuthorRepositroy.count());
        System.out.println("Number of Books: " + iBookRepository.count());
    }
}






