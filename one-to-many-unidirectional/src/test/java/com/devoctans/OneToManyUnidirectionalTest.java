package com.devoctans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OneToManyUnidirectionalTest {


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
    public void findPhone() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Person> phoneQuery = entityManager.createQuery("SELECT c FROM Person c JOIN FETCH c.phones WHERE c.id = :id", Person.class);
        phoneQuery.setParameter("id", 1L);

        Person person = phoneQuery.getSingleResult();

        assertThat(person.getPhones()).hasSize(2);

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
