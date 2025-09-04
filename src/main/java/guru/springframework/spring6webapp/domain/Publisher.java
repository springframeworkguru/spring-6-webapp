package guru.springframework.spring6webapp.domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String name;

    private String address;

    private String city;

    private String state;

    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }


    public String getZip() {
        return zip;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Publisher publisher)) {
            return false;
        }

        return getId().equals(publisher.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
