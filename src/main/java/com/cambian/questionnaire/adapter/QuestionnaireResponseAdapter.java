package com.cambian.questionnaire.adapter;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import com.cambian.questionnaire.dto.QuestionnaireResponseDto;
import com.cambian.questionnaire.entity.QuestionnaireResponse;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static void performValidations(final Object object) {
        String input = object.toString();
        FhirContext ctx = FhirContext.forR4();
        IParser parser = ctx.newJsonParser();
        parser.parseResource(org.hl7.fhir.r4.model.QuestionnaireResponse.class, input);
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

    public static Collection<QuestionnaireResponseDto> adaptCollection(
            final Collection<QuestionnaireResponse> responses) {
        return responses.stream()
                .filter(Objects::nonNull)
                .map(QuestionnaireResponseAdapter::adaptToDto)
                .collect(Collectors.toList());
    }
}
