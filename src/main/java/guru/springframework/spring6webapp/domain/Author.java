package guru.springframework.spring6webapp.domain;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

/**
 * POJO (plain old java object : a regular java class with private fields,getters and setters. "Optional :May have constructors")
 */
@Entity //this what tells JPA that this is going to be an Entity persisted to the database.
public class Author {

    // @Id marks this field as the primary key.
    // @GeneratedValue lets JPA automatically choose the best way to generate unique IDs based on the database when a new record is
    // inserted.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;


    //(mappedBy = "authors") tells JPA: Don’t create a second join table here—just mirror the mapping defined on Book.authors
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>() ;


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }


    // Helper for symmetry (optional)
    public void addBook(Book b) {
        this.books.add(b);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Author author)) {
            return false;
        }

        return Objects.equals(getId(), author.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
