package com.study.handson.controller;

import com.study.handson.model.Question;
import com.study.handson.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestions(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Void> addQuestion(@PathVariable String surveyId, @RequestBody Question question) {
        Question quest = surveyService.addQuestion(surveyId, question);
        if(quest == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").
                buildAndExpand(question.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
