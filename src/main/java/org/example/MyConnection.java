package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.JDBCConstants.*;

public class MyConnection {
    private static final Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MyConnection() {
    }

    public static Connection getConnection() {
        return connection;
    }
}