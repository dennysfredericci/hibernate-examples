package com.devoctans;

import java.util.Objects;

public class PersonFullName {

    private String fullName;

    public PersonFullName(String fullName) {
        this.fullName = fullName;
    }

    public String get() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonFullName that = (PersonFullName) o;
        return Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return "PersonFullName{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
