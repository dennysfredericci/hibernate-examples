package com.devoctans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ManyToManyBidirectionalTest {


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
    public void create() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        Course course = new Course();
        course.setName("Java Collections");
        entityManager.persist(course);

        Student student = new Student();
        student.setFirstName("Dennys");
        student.setLastName("Fredericci");
        student.getCourses().add(course);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
