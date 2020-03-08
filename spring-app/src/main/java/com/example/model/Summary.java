package com.example.model;

import com.example.entity.Answer;
import com.example.entity.Question;

import java.util.List;

public class Summary {

    private Long id;
    private String category;
    private String subCategory;
    private boolean multiSelect;
    private String text;
    private String explanation;

    private List<Answer> correctAnswers;
    private List<Answer> customerAnswers;

    public Summary(Question question, List<Answer> correctAnswers) {
        this.setId(question.getId());
        this.setCategory(question.getCategory());
        this.setSubCategory(question.getSubCategory());
        this.setMultiSelect(question.isMultiselect());
        this.setText(question.getText());
        this.setExplanation(question.getExplanation());
        this.setCustomerAnswers(question.getAnswers());
        this.setCorrectAnswers(correctAnswers);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<Answer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<Answer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public List<Answer> getCustomerAnswers() {
        return customerAnswers;
    }

    public void setCustomerAnswers(List<Answer> customerAnswers) {
        this.customerAnswers = customerAnswers;
    }
}
