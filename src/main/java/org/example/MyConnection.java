package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.JDBCConstants.*;

public class MyConnection {

    private static MyConnection myInstance;
    private Connection connection;

    private MyConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }

    public static MyConnection getInstance() throws SQLException {
        if (myInstance == null) {
            myInstance = new MyConnection();
        } else if (myInstance.getConnection().isClosed()) {
            myInstance = new MyConnection();
        }
        return myInstance;
    }
}