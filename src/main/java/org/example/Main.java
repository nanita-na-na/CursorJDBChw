package org.example;

import java.sql.SQLException;

import static org.example.Service.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        createTable();
        insertUsers();

        printUnderageUsers();
        printNameEndedO();
        printAgeBetween18And60();
        printAdultUsers();
        printCountNameHaveA();
    }
}