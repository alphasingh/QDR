package com.cambian.questionnaire.service;

import com.cambian.questionnaire.entity.QuestionnaireResponse;
import com.cambian.questionnaire.repository.QuestionnaireResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireResponseService {


    @Autowired
    private QuestionnaireResponseRepository repository;

    public QuestionnaireResponse saveQuestionnaire(QuestionnaireResponse toBeCreated) {
        return repository.save(toBeCreated);
    }

    public List<QuestionnaireResponse> getAllQuestionnaire() {
        return repository.findAll();
    }
}
