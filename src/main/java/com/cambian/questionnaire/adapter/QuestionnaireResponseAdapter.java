package com.cambian.questionnaire.adapter;

import com.cambian.questionnaire.dto.QuestionnaireResponseDto;
import com.cambian.questionnaire.entity.QuestionnaireResponse;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class QuestionnaireResponseAdapter {

    public static QuestionnaireResponse adaptForCreation(final QuestionnaireResponseDto toBeCreated) {
        return QuestionnaireResponse.builder()
                .name(toBeCreated.getName())
                .questionCount(toBeCreated.getQuestionCount())
                .description(toBeCreated.getDescription())
                .status(toBeCreated.getStatus())
                .code(toBeCreated.getCode())
                .services(toBeCreated.getServices())
                .build();
    }

    public static QuestionnaireResponseDto adaptToDto(final QuestionnaireResponse questionnaireWidget) {
        return QuestionnaireResponseDto.builder()
                .id(questionnaireWidget.getId())
                .name(questionnaireWidget.getName())
                .questionCount(questionnaireWidget.getQuestionCount())
                .description(questionnaireWidget.getDescription())
                .status(questionnaireWidget.getStatus())
                .code(questionnaireWidget.getCode())
                .services(questionnaireWidget.getServices())
                .build();
    }
}
