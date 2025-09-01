package com.yash.dao;

import com.yash.model.Student;

public interface StudentDao {
    int insert(Student student);
    int updateById(int id, Student student);
    int deleteById(int id);
}
