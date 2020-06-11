package com.devoctans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(country, that.country) &&
                Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, email, address, city, zipCode, country, person);
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", person=" + person +
                '}';
    }
}
