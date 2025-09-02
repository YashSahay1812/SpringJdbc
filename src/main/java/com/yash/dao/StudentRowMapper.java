package com.yash.dao;

import com.yash.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3)
        );
    }
}
