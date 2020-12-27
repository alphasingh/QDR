package com.cambian.questionnaire.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class QuestionnaireResponseDto {

    private String id;

    private String name;

    private String lname;

    private Integer questionCount;

    private String description;

    private String title;

    private String status;

    private String code;

    private String services;
}
