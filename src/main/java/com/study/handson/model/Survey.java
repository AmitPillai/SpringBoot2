package com.study.handson.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Survey {
    private String id;
    private String title;
    private String description;
    private List<Question> questions;
}
