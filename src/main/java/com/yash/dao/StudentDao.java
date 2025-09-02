package com.yash.dao;

import com.yash.model.Student;

import java.util.List;

public interface StudentDao {
    int insert(Student student);
    int updateById(int id, Student student);
    int deleteById(int id);
    Student getStudentById(int id);
    List<Student> getStudentsByCity(String city);
}
