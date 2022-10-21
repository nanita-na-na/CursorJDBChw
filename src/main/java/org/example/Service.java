package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.example.SqlQueries.*;

public class Service {

    public static void createTable() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE);
    }

    public static void insertUsers() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        statement.execute(INSERT_USERS);
    }

    public static void printUnderageUsers() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SELECT_UNDERAGE_USERS);
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

    public static void printNameEndedO() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SELECT_NAME_ENDED_O);
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

    public static void printAgeBetween18And60() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SELECT_BETWEEN_18_AND_60);
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

    public static void printAdultUsers() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SELECT_ADULT_USERS);
        resultSet.next();
        int count = resultSet.getInt("count");
        resultSet.close();
        System.out.println(count);
    }

    public static void printCountNameHaveA() throws SQLException {
        Connection connection = MyConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(SELECT_COUNT_NAME_HAVE_A);
        resultSet.next();
        int count = resultSet.getInt("count");
        resultSet.close();
        System.out.println(count);
    }
}