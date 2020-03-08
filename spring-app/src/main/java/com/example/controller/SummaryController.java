package com.example.controller;

import com.example.entity.Question;
import com.example.model.Summary;
import com.example.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SummaryController {

    private final SummaryService summaryService;

    @Autowired
    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @PostMapping("/result")
    public List<Summary> getResult(@RequestBody List<Question> answers){

        return summaryService.getResult(answers);
    }
}
