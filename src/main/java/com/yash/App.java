package com.yash;

import com.yash.dao.StudentDao;
import com.yash.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App
{
    public static void main( String[] args ) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        final StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

        int recordsUpdated = 0;

        final Student student1 = new Student("Yash", "Sasaram");
        recordsUpdated = studentDao.insert(student1);
        System.out.println(recordsUpdated + " record(s) inserted!");

        System.out.println(studentDao.getStudentById(1));

        student1.setCity("Hyderabad");
        recordsUpdated = studentDao.updateById(1, student1);
        System.out.println(recordsUpdated + " record(s) updated!");

        System.out.println(studentDao.getStudentById(1));

        final Student student2 = new Student("Sahay", "Hyderabad");
        recordsUpdated = studentDao.insert(student2);
        System.out.println(recordsUpdated + " record(s) inserted!");

        System.out.println(studentDao.getStudentById(2));

        final List<Student> students = studentDao.getStudentsByCity("Hyderabad");
        students.forEach(System.out::println);

        recordsUpdated = studentDao.deleteById(1);
        System.out.println(recordsUpdated + " record(s) deleted!");
        recordsUpdated = studentDao.deleteById(2);
        System.out.println(recordsUpdated + " record(s) deleted!");

    }
}
