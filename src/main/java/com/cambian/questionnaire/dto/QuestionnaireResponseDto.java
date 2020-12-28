package com.cambian.questionnaire.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class QuestionnaireResponseDto {

    private String id;

    private String name;

    private Integer questionCount;

    private String description;

    private String title;

    private String status;

    private String code;

    private String services;
}
