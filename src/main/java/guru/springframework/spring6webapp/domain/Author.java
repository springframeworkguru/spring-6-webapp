package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;
    private String m_firstName;
    private String m_lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return m_id;
    }

    public void setId(Long m_id) {
        this.m_id = m_id;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public void setFirstName(String m_firstName) {
        this.m_firstName = m_firstName;
    }

    public String getLastName() {
        return m_lastName;
    }

    public void setLastName(String m_lastName) {
        this.m_lastName = m_lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "m_id=" + m_id +
                ", m_firstName='" + m_firstName + '\'' +
                ", m_lastName='" + m_lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return m_id.equals(author.m_id);
    }

    @Override
    public int hashCode() {
        return m_id.hashCode();
    }
}
