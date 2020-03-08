package com.example.service;

import com.example.entity.Question;
import com.example.model.Summary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SummaryService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final AnswerService answerService;

    @Autowired
    public SummaryService(AnswerService answerService) {
        this.answerService = answerService;
    }

    public List<Summary> getResult(List<Question> responses){

        List<Summary> resultList = new LinkedList<>();
        for (Question question : responses) {

            question.getAnswers().removeIf(answer -> (!answer.isCorrect()));
            Summary result = new Summary(question, answerService.getCorrectAnswersForQuestion(question.getId()));
            resultList.add(result);
        }

        return resultList;
    }
}
