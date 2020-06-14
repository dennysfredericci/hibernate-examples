package com.devoctans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Name {

    @Column(name = "firstname")
    private String first;

    @Column(name = "lastname")
    private String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFull() {
        return first + " " + last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(first, name.first) &&
                Objects.equals(last, name.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
