package com.devoctans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    @OneToOne(mappedBy = "person")
    private EasyApproach easyApproach;

    @OneToOne(mappedBy = "person")
    private PerformanceApproach performanceApproach;

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

    public EasyApproach getEasyApproach() {
        return easyApproach;
    }

    public void setEasyApproach(EasyApproach easyApproach) {
        this.easyApproach = easyApproach;
    }

    public PerformanceApproach getPerformanceApproach() {
        return performanceApproach;
    }

    public void setPerformanceApproach(PerformanceApproach performanceApproach) {
        this.performanceApproach = performanceApproach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(easyApproach, that.easyApproach) &&
                Objects.equals(performanceApproach, that.performanceApproach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, easyApproach, performanceApproach);
    }

    @Override
    public String toString() {
        return "PersonEasyApproach{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
