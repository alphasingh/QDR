package com.cambian.questionnaire.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Document(collection="questionnaire")
public class QuestionnaireResponse {

    @Id
    private String id;

    private String name;

    private Integer questionCount;

    private String description;

    private String status;

    private String code;

    private String services;
}
