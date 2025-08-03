package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBook;
    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name ="author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id")) // This annotation defines the join table for the many-to-many relationship
    private Set<Author> authors = new HashSet<>();

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;

        return Objects.equals(getIdBook(), book.getIdBook());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdBook());
    }

}




