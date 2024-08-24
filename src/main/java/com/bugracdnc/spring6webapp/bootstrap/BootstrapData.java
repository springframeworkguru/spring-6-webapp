package com.bugracdnc.spring6webapp.bootstrap;

import com.bugracdnc.spring6webapp.domain.Author;
import com.bugracdnc.spring6webapp.domain.Book;
import com.bugracdnc.spring6webapp.repositories.AuthorRepository;
import com.bugracdnc.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author oguzatay = new Author();
        oguzatay.setFirstName("Oguz");
        oguzatay.setLastName("Atay");

        Book tutunamayanlar = new Book();
        tutunamayanlar.setTitle("Tutunamayanlar");
        tutunamayanlar.setIsbn("123456");

        Book tehlikeliOyunlar = new Book();
        tehlikeliOyunlar.setTitle("Tehlikeli Oyunlar");
        tehlikeliOyunlar.setIsbn("123457");

        Author oguzataySaved = authorRepository.save(oguzatay);
        Book tutunamayanlarSaved = bookRepository.save(tutunamayanlar);
        Book tehlikeliOyunlarSaved = bookRepository.save(tehlikeliOyunlar);

        oguzataySaved.getBooks().add(tutunamayanlarSaved);
        oguzataySaved.getBooks().add(tehlikeliOyunlarSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
