package com.devoctans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManyToOneUnidirectionalTest {


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

        TypedQuery<Phone> phoneQuery = entityManager.createQuery("SELECT c FROM Phone c WHERE c.person.id = :id", Phone.class);
        phoneQuery.setParameter("id", 1L);

        List<Phone> resultList = phoneQuery.getResultList();

        assertThat(resultList).hasSize(2);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Test
    public void createPersonAndPhone() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person = new Person();
        person.setId(2L);
        person.setFirstName("Dennys");
        person.setLastName("Fredericci");

        entityManager.persist(person);

        Phone phone = new Phone();
        phone.setId(3L);
        phone.setNumber("555555555");
        phone.setPerson(person);
        entityManager.persist(phone);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
