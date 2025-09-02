package com.yash;

import com.yash.dao.StudentDao;
import com.yash.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {

        final ApplicationContext context = new ClassPathXmlApplicationContext(
                "config.xml");

        final StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

        int recordsUpdated = 0;

        final Student student = new Student("Yash", "Sasaram");
        recordsUpdated = studentDao.insert(student);
        System.out.println(recordsUpdated + " record(s) inserted!");

        System.out.println(studentDao.getStudentById(1));

        student.setCity("Hyderabad");
        recordsUpdated = studentDao.updateById(1, student);
        System.out.println(recordsUpdated + " record(s) updated!");

        System.out.println(studentDao.getStudentById(1));

        recordsUpdated = studentDao.deleteById(1);
        System.out.println(recordsUpdated + " record(s) deleted!");

    }
}
