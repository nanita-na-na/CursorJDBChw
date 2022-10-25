package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.SqlQueries.CREATE_TABLE;
import static org.example.SqlQueries.INSERT_USERS;

public class Service {

    public void createTable() throws SQLException {
        Connection connection = MyConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE);
    }

    public void insertUsers() throws SQLException {
        Connection connection = MyConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(INSERT_USERS);
    }

    public void selectUsers(String query) throws SQLException {
        Connection connection = MyConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        var users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setGender(resultSet.getString("gender"));
            user.setAge(resultSet.getInt("age"));

            users.add(user);
        }
        users.forEach(System.out::println);
    }

    public void selectCountUsers(String query) throws SQLException {
        Connection connection = MyConnection.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        int count = resultSet.getInt("count");
        resultSet.close();
        System.out.println(count);
    }
}