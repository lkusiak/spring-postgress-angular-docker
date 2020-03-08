package com.example.service;


import com.example.entity.Answer;
import com.example.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }


    List<Answer> getCorrectAnswersForQuestion(Long questionId){
        Answer sample = new Answer();
        sample.setQuestionId(questionId);
        sample.setCorrect(true);

        Example<Answer> answerExample = Example.of(sample, ExampleMatcher.matchingAll());
        List<Answer> answers = answerRepository.findAll(answerExample);

        return answers;
    }
}
