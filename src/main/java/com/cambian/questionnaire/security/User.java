package com.cambian.questionnaire.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String name;
    private String username;
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    private List<String> roles;
}