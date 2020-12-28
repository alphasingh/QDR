package com.cambian.questionnaire.controller;

import com.cambian.questionnaire.adapter.QuestionnaireResponseAdapter;
import com.cambian.questionnaire.dto.QuestionnaireResponseDto;
import com.cambian.questionnaire.entity.QuestionnaireResponse;
import com.cambian.questionnaire.service.QuestionnaireResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionnaireResponseController {

    @Autowired
    private QuestionnaireResponseService service;

    @PostMapping("/add")
    public ResponseEntity<QuestionnaireResponseDto> saveQuestionnaire(@RequestBody QuestionnaireResponseDto requestDto) {
        final QuestionnaireResponse toBeCreated = QuestionnaireResponseAdapter.adaptForCreation(requestDto);
        final QuestionnaireResponse created = service.saveQuestionnaire(toBeCreated);
        final QuestionnaireResponseDto questionnaireResponse = QuestionnaireResponseAdapter.adaptToDto(created);
        return new ResponseEntity<QuestionnaireResponseDto>(questionnaireResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<QuestionnaireResponse> getAllQuestionnaire() {
        return service.getAllQuestionnaire();
    }

}
