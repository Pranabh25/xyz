package com.springboot.ecom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ecom_logistics"; // Replace with your DB URL
    private static final String USERNAME = "root";
    private static final String PASSWORD = "2024";

    static {
        try {
            // Load the JDBC driver (optional step for some newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8.0+
        } catch (ClassNotFoundException e) {
            System.err.println("Database driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // Establish and return a database connection
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
