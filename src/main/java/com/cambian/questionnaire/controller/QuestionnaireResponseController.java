package com.cambian.questionnaire.controller;

import com.cambian.questionnaire.adapter.QuestionnaireResponseAdapter;
import com.cambian.questionnaire.dto.QuestionnaireResponseDto;
import com.cambian.questionnaire.entity.QuestionnaireResponse;
import com.cambian.questionnaire.repository.QuestionnaireResponseRepository;
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
    private QuestionnaireResponseRepository repository;

    @PostMapping("/add")
    public ResponseEntity<QuestionnaireResponse> saveQuestionnaire(@RequestBody QuestionnaireResponseDto requestDto) {
        final QuestionnaireResponse toBeCreated = QuestionnaireResponseAdapter.adaptForCreation(requestDto);
        repository.save(toBeCreated);
        final QuestionnaireResponseDto widgetResponse = QuestionnaireResponseAdapter.adaptToDto(toBeCreated);
        return new ResponseEntity<>(toBeCreated, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<QuestionnaireResponse> getAllQuestionnaire() {
        return repository.findAll();
    }

}
