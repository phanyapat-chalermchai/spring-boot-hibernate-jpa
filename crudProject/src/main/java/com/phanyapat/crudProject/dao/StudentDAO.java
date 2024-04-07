package com.phanyapat.crudProject.dao;

import com.phanyapat.crudProject.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

}
