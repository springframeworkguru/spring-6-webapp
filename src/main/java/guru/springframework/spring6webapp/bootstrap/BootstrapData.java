package guru.springframework.spring6webapp.bootstrap;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.IAuthorRepository;
import guru.springframework.spring6webapp.repositories.IBookRepository;
import guru.springframework.spring6webapp.repositories.IPublischerRepository;

@Component
public class BootstrapData implements CommandLineRunner { // CommandLineRunner will execute the run methode every time spring boot starts.

    private final IAuthorRepository authorRepository;
    private final IBookRepository bookRepository;
    private final IPublischerRepository publischerRepository;

    @PersistenceContext
    private EntityManager entityManager; // injected by Spring


    //When Spring sees this component (BootstrapData) , it sees a constructor says we have to autowire these components.
    public BootstrapData(IAuthorRepository authorRepository, IBookRepository bookRepository, IPublischerRepository publischerRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publischerRepository = publischerRepository;
    }


    /**
     * Runs once at startup. The @Transactional keeps a single persistence context
     * open while we insert, link, flush/clear, and verify the data.
     */
    @Transactional
    @Override
    public void run(String... args) {
//
//        // 0) Idempotency (avoid re-seeding on every restart)
//        if (authorRepository.count() > 0 || bookRepository.count() > 0) {
//            System.out.println("Bootstrap skipped (data already present).");
//            return;
//        }

        // 1) Create Authors
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Guru");

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        // 2) Create Books
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Publisher publisher = new Publisher();
        publisher.setName("PublisherA");
        publisher.setAddress("123 Main St");


        // 3) Persist ends (order not strict; cascades could simplify this)
        authorRepository.save(eric);
        authorRepository.save(rod);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);
        publischerRepository.save(publisher);

        // 4) LINK ON THE OWNING SIDE (Book owns @ManyToMany)
        //    This is what causes join rows to be persisted.
        ddd.getAuthors().add(eric);    // DDD ? Eric
        noEJB.getAuthors().add(rod);   // noEJB ? Rod

        // (Optional) Mirror inverse side for in-memory consistency
//        eric.getBooks().add(ddd);
//        rod.getBooks().add(noEJB);

        //link publisher
        ddd.setPublisher(publisher);
        noEJB.setPublisher(publisher);

        // 5) Persist the OWNERs so Hibernate writes the join table rows
        bookRepository.save(ddd);
        bookRepository.save(noEJB);

        System.out.println("In BootstrapData");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        // 6) Force pending SQL to DB, then detach everything so re-reads hit the DB
        entityManager.flush();  // push INSERTs for join table
        entityManager.clear();  // detach managed instances (no cached collections)

        // 7) VERIFY with fresh loads (no in-memory illusions)
        Author ericDb = authorRepository.findById(eric.getId()).orElseThrow();
        System.out.println("Eric's books (from DB): " + ericDb.getBooks().size()); // expect 1

        Book dddDb = bookRepository.findById(ddd.getId()).orElseThrow();
        System.out.println("DDD book authors (from DB): " + dddDb.getAuthors().size()); // expect 1
        System.out.println("DDD book publisher (from DB): " + dddDb.getPublisher().getName());







    }

}
