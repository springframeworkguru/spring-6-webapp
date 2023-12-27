package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;
    private String m_publisherName;
    private String m_address;
    private String m_city;
    private String m_state;
    private String m_zip;

    @OneToMany(mappedBy = "publisher")
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

    public String getPublisherName() {
        return m_publisherName;
    }

    public void setPublisherName(String m_publisherName) {
        this.m_publisherName = m_publisherName;
    }

    public String getAddress() {
        return m_address;
    }

    public void setAddress(String m_address) {
        this.m_address = m_address;
    }

    public String getCity() {
        return m_city;
    }

    public void setCity(String m_city) {
        this.m_city = m_city;
    }

    public String getState() {
        return m_state;
    }

    public void setState(String m_state) {
        this.m_state = m_state;
    }

    public String getZip() {
        return m_zip;
    }

    public void setZip(String m_zip) {
        this.m_zip = m_zip;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "m_id=" + m_id +
                ", m_publisherName='" + m_publisherName + '\'' +
                ", m_address='" + m_address + '\'' +
                ", m_city='" + m_city + '\'' +
                ", m_state='" + m_state + '\'' +
                ", m_zip='" + m_zip + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return m_id.equals(publisher.m_id);
    }

    @Override
    public int hashCode() {
        return m_id.hashCode();
    }
}
