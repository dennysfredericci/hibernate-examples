package com.devoctans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OneToOneUnidirectionalTest {


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
    public void findContactInfo() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<ContactInfo> personQuery = entityManager.createQuery("SELECT c FROM ContactInfo c WHERE c.id = :id", ContactInfo.class);
        personQuery.setParameter("id", 1L);

        ContactInfo contactInfo = personQuery.getSingleResult();

        assertThat(contactInfo.getPerson()).isNotNull();

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
