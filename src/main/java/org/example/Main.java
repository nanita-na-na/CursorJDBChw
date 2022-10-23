package org.example;

import java.sql.SQLException;

import static org.example.SqlQueries.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Service service = new Service();

        service.createTable();
        service.insertUsers();

        service.selectUsers(SELECT_UNDERAGE_USERS);
        service.selectUsers(SELECT_NAME_ENDED_O);
        service.selectUsers(SELECT_BETWEEN_18_AND_60);
        service.selectCountUsers(SELECT_COUNT_NAME_HAVE_A);
        service.selectCountUsers(SELECT_ADULT_USERS);

        MyConnection.getConnection().close();
    }
}