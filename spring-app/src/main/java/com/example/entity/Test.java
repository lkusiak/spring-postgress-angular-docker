package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Test {


    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 2048)
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "test_id")
    private List<Question> questions;

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void updateQuestions(List<Question> questions){
        this.questions.clear();
        this.questions.addAll(questions);
    }
}
