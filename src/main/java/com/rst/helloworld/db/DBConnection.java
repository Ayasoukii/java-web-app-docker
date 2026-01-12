package com.rst.helloworld.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://emp_db:3306/employees_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "aya";
        String pass = "aya";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
}
