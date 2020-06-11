package com.devoctans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Objects;

@Entity
public class PerformanceApproach implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Person person;

    @Lob
    private Clob bio;

    @Lob
    private Blob picture;

    public Clob getBio() {
        return bio;
    }

    public void setBio(Clob bio) {
        this.bio = bio;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformanceApproach that = (PerformanceApproach) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, bio, picture);
    }

    @Override
    public String toString() {
        return "PerformanceApproach{" +
                "id=" + id +
                ", bio=" + bio +
                ", picture=" + picture +
                '}';
    }
}
