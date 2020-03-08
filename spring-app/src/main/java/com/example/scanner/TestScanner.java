package com.example.scanner;


import com.example.entity.Question;
import com.example.entity.Test;
import com.example.repository.TestRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TestScanner {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final TestRepository testRepository;

    @Autowired
    public TestScanner(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Scheduled(cron = "0 * * ? * *")
    @Transactional
    @PostConstruct
    public void loadResources() {

        try (Stream<Path> paths = Files.walk(Paths.get("/Users/lukaszkusiak/Desktop/quest"))) {
            List<Test> tests = paths.filter(Files::isRegularFile)
                    .map(this::getResourceAsTest)
                    .collect(Collectors.toList());
            testRepository.save(tests);

        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }

    }

    private Test getResourceAsTest(Path filePath) {
        LOGGER.info(filePath.getFileName().toString());
        File resource = filePath.toFile();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questions = null;
        try {
            questions = objectMapper.readValue(resource, new TypeReference<LinkedList<Question>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        Test test = new Test();
        test.setName(resource.getName());
        Example<Test> testExample = Example.of(test, ExampleMatcher.matchingAll());
        Test matchingTest = testRepository.findOne(testExample);
        if(matchingTest != null){
            test = matchingTest;

        }else{
            test.setQuestions(questions);
        }

        return test;

    }
}
