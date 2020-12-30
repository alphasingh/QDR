package com.cambian.questionnaire.controller;

import com.cambian.questionnaire.adapter.QuestionnaireResponseAdapter;
import com.cambian.questionnaire.config.OpenApiDocsConfig;
import com.cambian.questionnaire.dto.QuestionnaireResponseDto;
import com.cambian.questionnaire.entity.QuestionnaireResponse;
import com.cambian.questionnaire.service.QuestionnaireResponseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/questionnaireResponses")
public class QuestionnaireResponseController {

    @Autowired
    private QuestionnaireResponseService service;

    @PostMapping
    @Operation(security = {@SecurityRequirement(name = OpenApiDocsConfig.SECURITY_KEY)})
    public ResponseEntity<QuestionnaireResponseDto> saveQuestionnaire(
            @RequestBody QuestionnaireResponseDto requestDto) {
        //QuestionnaireResponseAdapter.performValidations(requestDto);
        final QuestionnaireResponse toBeCreated = QuestionnaireResponseAdapter.adaptForCreation(requestDto);
        final QuestionnaireResponse created = service.saveQuestionnaire(toBeCreated);
        final QuestionnaireResponseDto questionnaireResponse = QuestionnaireResponseAdapter.adaptToDto(created);
        return new ResponseEntity<>(questionnaireResponse, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(security = {@SecurityRequirement(name = OpenApiDocsConfig.SECURITY_KEY)})
    public ResponseEntity<Collection<QuestionnaireResponseDto>> getAllQuestionnaire() {
        final Collection<QuestionnaireResponseDto> responseDtoCollection
                = QuestionnaireResponseAdapter.adaptCollection(service.getAllQuestionnaire());
        return new ResponseEntity<>(responseDtoCollection, HttpStatus.OK);
    }

}
