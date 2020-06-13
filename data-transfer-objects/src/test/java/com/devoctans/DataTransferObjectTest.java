package com.devoctans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class DataTransferObjectTest {


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
    public void testUsingJPQL() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<PersonFullName> personQuery = entityManager.createQuery("SELECT new com.devoctans.PersonFullName( CONCAT(p.firstName, ' ', p.lastName)) FROM Person p WHERE p.id = :id", PersonFullName.class);
        personQuery.setParameter("id", 1L);

        PersonFullName personFullName = personQuery.getSingleResult();

        assertThat(personFullName.get()).isEqualTo("DENNYS FREDERICCI");

        entityManager.getTransaction().commit();
        entityManager.close();

    }


    @Test
    public void testUsingNativeQuery() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query personQuery = entityManager.createNativeQuery("select CONCAT(p.firstName, ' ', p.lastName) as fullname from Person p where p.id= :id", "PersonFullName");
        personQuery.setParameter("id", 1L);

        PersonFullName personFullName = (PersonFullName) personQuery.getSingleResult();

        assertThat(personFullName.get()).isEqualTo("DENNYS FREDERICCI");

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void testUsingTuple() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Tuple> personQuery = entityManager.createQuery("SELECT CONCAT(p.firstName, ' ', p.lastName) as fullName FROM Person p WHERE p.id = :id", Tuple.class);
        personQuery.setParameter("id", 1L);

        Tuple personFullName = personQuery.getSingleResult();

        assertThat(personFullName.get("fullName")).isEqualTo("DENNYS FREDERICCI");

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
