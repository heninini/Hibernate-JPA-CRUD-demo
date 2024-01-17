package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findby(Integer id);
    List<Student> findAll();
    List<Student> findName(String lastName);

    void update(Student theStudent);
    void delete(int Id);
    int deleteAll();

}