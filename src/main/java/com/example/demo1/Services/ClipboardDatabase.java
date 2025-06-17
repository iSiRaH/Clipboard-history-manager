package com.example.demo1.Services;

import java.sql.*;
import java.time.LocalDateTime;

public class ClipboardDatabase {
    private Connection connection;

    // Database connection and setup
    public Connection connectDatabase() {
        try {
            // Update the path as needed for your environment
            Class.forName("com.mysql.cj.jdbc.Driver");
            //database credentials
            String url = "jdbc:mysql://localhost:3306/clipboarddatabase";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertClipboarditem(String currentText) {
        PreparedStatement statement;
        String query = "INSERT INTO  clipboarditem (content, timestamp) VALUES (? , ?);";
        String timestamp = LocalDateTime.now().toString();

        try {
            connectDatabase();
            if(connection == null){
                System.out.println("Database connection failed.");
                return;
            }

            statement = connection.prepareStatement(query);
            statement.setString(1, currentText);
            statement.setString(2, timestamp);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
