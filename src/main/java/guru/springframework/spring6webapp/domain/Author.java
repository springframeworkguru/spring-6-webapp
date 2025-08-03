package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity // this annotation indicates that this class is a JPA entity
public class Author {
    @Id // This annotation indicates that this field is the primary key of the entity
    @GeneratedValue (strategy = GenerationType.AUTO) // this annotation specifies that the primary key will be generated automatically
    private Long idAuthor;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors") // this annotation indicates a many-to-many relationship with the Book entity
    private Set<Book> books = new HashSet<>();

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;

        return Objects.equals(getIdAuthor(), author.getIdAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdAuthor());
    }

}





