package guru.springframework.spring6webapp.bookstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String...args) throws Exception{
        Author eric=new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd=new Book();
        ddd.setTitle("Domain Driven Desing");
        ddd.setIbsn("123456");

        Author ericSaved=authorRepository.save(eric);
        Book addSaved=bookRepository.save(ddd);

        Author rod=new Author();
        rod.setFirstName("Rod");
        rod.setLastName("JohnSon");

        Book noEJB=new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIbsn("54757585");

        Author rodSaved=authorRepository.save(rod);
        Book noEJBSaved=bookRepository.save(noEJB);

        ericSaved.getBooks().add(addSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count : " +authorRepository.count());
        System.out.println("Book Count : "+bookRepository.count() );
    }
}
