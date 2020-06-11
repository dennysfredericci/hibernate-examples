package com.devoctans;

import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LargeObjectsTest {


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
    public void testTheEasyApproach() throws IOException {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, 1L);

        EasyApproach easyApproach = new EasyApproach();
        easyApproach.setBio("This is a long text to test a Clob. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        easyApproach.setPicture(getProfilePicture());
        easyApproach.setPerson(person);
        person.setEasyApproach(easyApproach);
        entityManager.persist(easyApproach);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void testThePerformanceApproach() throws IOException {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Person person = entityManager.find(Person.class, 1L);

        PerformanceApproach performanceApproach = new PerformanceApproach();
        performanceApproach.setBio(ClobProxy.generateProxy("This is a long text to test a Clob. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        performanceApproach.setPicture(BlobProxy.generateProxy(getProfilePicture()));
        performanceApproach.setPerson(person);
        person.setPerformanceApproach(performanceApproach);
        entityManager.persist(performanceApproach);

        entityManager.getTransaction().commit();
        entityManager.close();

    }


    private byte[] getProfilePicture() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/profile.jpg");
        return inputStream.readAllBytes();
    }


}
