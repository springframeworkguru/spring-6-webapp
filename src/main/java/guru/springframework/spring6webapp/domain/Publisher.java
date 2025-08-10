package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPublisher;
    private String publisherName;
    private String publisherAddress;
    private String publisherCity;
    private String publisherState;
    private String publisherZip;

    public Long getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Long idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public String getPublisherState() {
        return publisherState;
    }

    public void setPublisherState(String publisherState) {
        this.publisherState = publisherState;
    }

    public String getPublisherZip() {
        return publisherZip;
    }

    public void setPublisherZip(String publisherZip) {
        this.publisherZip = publisherZip;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "idPublisher=" + idPublisher +
                ", publisherName='" + publisherName + '\'' +
                ", publisherAddress='" + publisherAddress + '\'' +
                ", publisherCity='" + publisherCity + '\'' +
                ", publisherState='" + publisherState + '\'' +
                ", publisherZip='" + publisherZip + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Publisher publisher)) return false;

        return Objects.equals(getIdPublisher(), publisher.getIdPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdPublisher());
    }
}
