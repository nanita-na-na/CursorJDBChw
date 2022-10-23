package org.example;

import lombok.Data;

@Data

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
}