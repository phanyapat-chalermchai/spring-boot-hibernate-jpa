package com.phanyapat.crudProject.dao;

import com.phanyapat.crudProject.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
