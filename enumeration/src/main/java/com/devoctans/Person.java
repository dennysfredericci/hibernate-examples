package com.devoctans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Status statusName;

    // Avoid this approach
    @Enumerated(EnumType.ORDINAL)
    private Status statusOrdinal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Status getStatusName() {
        return statusName;
    }

    public void setStatusName(Status statusName) {
        this.statusName = statusName;
    }

    public Status getStatusOrdinal() {
        return statusOrdinal;
    }

    public void setStatusOrdinal(Status statusOrdinal) {
        this.statusOrdinal = statusOrdinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                statusName == person.statusName &&
                statusOrdinal == person.statusOrdinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, statusName, statusOrdinal);
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", statusName=" + statusName +
                ", statusOrdinal=" + statusOrdinal +
                '}';
    }
}
