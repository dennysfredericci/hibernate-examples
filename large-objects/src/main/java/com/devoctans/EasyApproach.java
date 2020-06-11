package com.devoctans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class EasyApproach implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private Person person;

    @Lob
    private String bio;

    @Lob
    private byte[] picture;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
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
        EasyApproach that = (EasyApproach) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(person, that.person) &&
                Objects.equals(bio, that.bio) &&
                Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, person, bio);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

    @Override
    public String toString() {
        return "EasyApproach{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
