package com.henrybooks.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publisher {
    private String publisherCode;
    private String publisherName;
    private String city;

    @Id
    @Column(name = "publishercode")
    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    @Basic
    @Column(name = "publishername")
    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (publisherCode != null ? !publisherCode.equals(publisher.publisherCode) : publisher.publisherCode != null)
            return false;
        if (publisherName != null ? !publisherName.equals(publisher.publisherName) : publisher.publisherName != null)
            return false;
        if (city != null ? !city.equals(publisher.city) : publisher.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publisherCode != null ? publisherCode.hashCode() : 0;
        result = 31 * result + (publisherName != null ? publisherName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
