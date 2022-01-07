package com.company.DbConnection;

import com.company.Entity.Course;
import com.company.Entity.Instructor;
import com.company.Entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection getConnection() throws Exception {
        String jbcUrl = "jdbc:mysql://localhost:3306/uni";
        String user = "student";
        String password = "student";
        return DriverManager.getConnection(jbcUrl, user, password);
    }

    public static SessionFactory getSessionConnection() throws Exception {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        return factory;
    }
}
