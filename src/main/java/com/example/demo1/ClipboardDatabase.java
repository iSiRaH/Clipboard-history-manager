package com.example.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ClipboardDatabase {
   private Connection connection;



    // Database connection and setup

    public void connect() {
        try {
            // Update the path as needed for your environment
//
//            String url = "jdbc:mysql:clipboard.sql";
//            connection = java.sql.DriverManager.getConnection(url);
            String url = "jdbc:mysql://localhost:3306/clipboarddatabase";
            String username = "root"; // replace with your actual username
            String password = ""; // replace with your actual password

            connection = DriverManager.getConnection(url, username, password);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertClipboarditem(String currentText) throws SQLException {
        Statement statement = null;
        String query = null;
        try {
            connect();
            statement = connection.createStatement();
            System.out.println("Connection to SQLite has been established.");

            query = "INSERT INTO  clipboarditem VALUES (1,"+currentText+", NULL);";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Connect to the clipboard.sql database
    }
}
