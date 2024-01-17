package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    public EntityManager entitymanager;

    @Autowired
    public StudentDAOImpl(EntityManager entitymanager) {
        this.entitymanager = entitymanager;
    }



    @Override
    @Transactional
    public void save(Student theStudent) {
        entitymanager.persist(theStudent);
    }

    @Override
    public Student findby(Integer id) {
        return entitymanager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery= entitymanager.createQuery("FROM Student",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findName(String lastName) {
        TypedQuery<Student> theQuery= entitymanager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
//set the parameters
        theQuery.setParameter("theData",lastName);
//        getResult
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entitymanager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int Id) {
//        retrieve the student
        Student theStudent=entitymanager.find(Student.class,Id);

//        delete the student
     entitymanager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted= entitymanager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }


}