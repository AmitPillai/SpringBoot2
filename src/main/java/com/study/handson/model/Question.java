package com.study.handson.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Question {
    private String id;
    private String description;
    private String correctAnswer;
    private List<String> options;
}
