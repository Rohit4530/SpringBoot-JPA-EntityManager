package com.crud.dao;

import com.crud.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public Student findById(int Id);
    public List<Student> findAll();
    public void update(Student theStudent);
    public void deleteStudent(int id);
}
