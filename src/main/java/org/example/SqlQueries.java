package org.example;

public final class SqlQueries {

    private SqlQueries() {
    }

    public static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS user (
            id int PRIMARY KEY AUTO_INCREMENT,
            first_name varchar(50),
            last_name varchar(50),
            gender varchar(50),
            age int)
            """;
    public static final String INSERT_USERS = """
             INSERT INTO user (first_name, last_name, gender, age)
              VALUES ('Johnny', 'Depp', 'masculine', 59), ('Angelina', 'Jolie', 'feminine', 47),
              ('Jim', 'Carrey', 'masculine', 60), ('Jennifer', 'Aniston', 'feminine', 53),
              ('Courteney', 'Cox', 'feminine', 58), ('Lisa', 'Kudrow', 'feminine', 59),
              ('Matt', 'LeBlanc', 'masculine', 55), ('Matthew', 'Perry', 'masculine', 53),
              ('Maria', 'Shevchenko', 'feminine', 12), ('Ivan', 'Sokyra', 'masculine', 15);
            """;
    public static String SELECT_UNDERAGE_USERS = """
            SELECT * FROM user WHERE age < 18
            """;
    public static String SELECT_NAME_ENDED_O = """
            SELECT * FROM user WHERE first_name LIKE '%o'
            """;
    public static String SELECT_BETWEEN_18_AND_60 = """
            SELECT * FROM user WHERE age BETWEEN 18 AND 60
            """;
    public static String SELECT_COUNT_NAME_HAVE_A = """
            SELECT COUNT(*) AS count FROM user WHERE first_name LIKE '%a%'
            """;
    public static String SELECT_ADULT_USERS = """
            SELECT COUNT(*) AS count FROM user WHERE age >=18
            """;
}