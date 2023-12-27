package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;
    private String m_title;
    private String m_isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author"),
            inverseJoinColumns = @JoinColumn(name = "book"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return m_id;
    }

    public void setId(Long id) {
        this.m_id = id;
    }

    public String getTitle() {
        return m_title;
    }

    public void setTitle(String name) {
        this.m_title = name;
    }

    public String getIsbn() {
        return m_isbn;
    }

    public void setIsbn(String isbn) {
        this.m_isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "m_id=" + m_id +
                ", m_name='" + m_title + '\'' +
                ", m_isbn='" + m_isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return m_id.equals(book.m_id);
    }

    @Override
    public int hashCode() {
        return m_id.hashCode();
    }
}
