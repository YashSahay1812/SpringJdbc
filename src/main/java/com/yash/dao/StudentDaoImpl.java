package com.yash.dao;

import com.yash.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(final Student student) {
        final String insertQuery = "INSERT INTO student(name, city) VALUES(?,?)";
        return jdbcTemplate.update(
            insertQuery,
            student.getName(),
            student.getCity()
        );
    }

    @Override
    public int updateById(final int id, final Student student) {
        final String updateQuery = "UPDATE student SET name=?, city=? WHERE id=?";
        return jdbcTemplate.update(
            updateQuery,
            student.getName(),
            student.getCity(),
            id
        );
    }

    @Override
    public int deleteById(final int id) {
        final String deleteQuery = "DELETE FROM student WHERE id=?";
        return jdbcTemplate.update(deleteQuery, id);
    }

    @Override
    public Student getStudentById(final int id) {
        final String selectQuery = "SELECT * FROM student WHERE id=?";
        return jdbcTemplate.queryForObject(
            selectQuery,
            (resultSet, _rowNum) -> new Student(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
            ),
            id
        );
    }

    @Override
    public List<Student> getStudentsByCity(final String city) {
        final String selectQuery = "SELECT * FROM student WHERE city=?";
        return jdbcTemplate.query(
            selectQuery,
            (resultSet, _rowNum) -> new Student(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3)
            ),
            city
        );
    }

}
