package com.example.service;

import com.example.entity.Question;
import com.example.entity.Test;
import com.example.repository.TestRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TestService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final TestRepository testRepository;
    private final ResourceLoader resourceLoader;

    @Autowired
    public TestService(TestRepository testRepository, ResourceLoader resourceLoader) {
        this.testRepository = testRepository;
        this.resourceLoader = resourceLoader;
    }

//    @Transactional
//    @PostConstruct
//    public void init() {
//
//        //String data = getStringResourceContent("questions.json");
//        try {
//            Resource[] resuorces = loadResources("classpath:*.json");
//            List<Test> tests = new ArrayList<>();
//            ObjectMapper objectMapper = new ObjectMapper();
//            LOGGER.info(String.valueOf( resuorces.length));
//
//            for (Resource resuorce : resuorces) {
//                String fileName = resuorce.getFilename();
//                File file = resuorce.getFile();
//                List<Question> questions = objectMapper.readValue(file, new TypeReference<LinkedList<Question>>() {
//                });
//                Test test = new Test();
//                test.setName(fileName);
//                test.setQuestions(questions);
//
//                tests.add(test);
//            }
//            testRepository.save(tests);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    Resource[] loadResources(String pattern) throws IOException {
//        return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(pattern);
//    }
//
//    private String getStringResourceContent(String fileName) {
//        Resource resource = new ClassPathResource(fileName);
//        String data = "";
//        try {
//            InputStream inputStream = resource.getInputStream();
//            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
//            data = new String(bdata, StandardCharsets.UTF_8);
//            LOGGER.info(data);
//        } catch (IOException e) {
//            LOGGER.error("IOException", e);
//        }
//
//        return data;
//    }
}
