package com.devoctans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AttributeConverterTest {


    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default-persistence-unit");
    }

    @After
    public void close() {
        entityManagerFactory.close();
    }

    @Test
    public void findPerson() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Person> personQuery = entityManager.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class);
        personQuery.setParameter("id", 1L);

        Person person = personQuery.getSingleResult();
        assertThat(person.getStatus()).isEqualTo(Status.ACTIVE);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
