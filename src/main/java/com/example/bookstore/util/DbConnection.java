package com.example.bookstore.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection getConnection() throws Exception {
        String jbcUrl = "jdbc:mysql://localhost:3306/book-store?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "bookstore";
        String password = "bookstore";
        return DriverManager.getConnection(jbcUrl, user, password);
    }

}
