package com.example.demo.collections;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Setter
@Getter
@ToString
@Document
public class User {

    @Id
    String userId;
    String userName;
    String firstName;
    String lastName;
    String rollNumber;
}
