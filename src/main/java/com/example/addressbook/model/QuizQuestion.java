package com.example.addressbook.model;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizQuestion {
    private String questionText;
    private ArrayList<String> answers;
    private int correctAnswer; // index of correct answer in answers list

    public QuizQuestion() {
        this.questionText = "Question Text";
        this.answers = new ArrayList<>(Arrays.asList("Option A", "Option B", "Option C", "Option D"));
        this.correctAnswer = 0;
    }
    public QuizQuestion(String questionText, ArrayList<String> answers, int correctAnswer) throws IndexOutOfBoundsException {
        this.questionText = questionText;
        this.answers = answers;
        if (correctAnswer >= answers.size()) {
            throw new IndexOutOfBoundsException("Provided correctAnswer index is not within range of provided answers list");
        } else {
            this.correctAnswer = correctAnswer;
        }
    }

    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }
    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer) {
        if (correctAnswer >= answers.size() || correctAnswer < 0) {
            throw new IndexOutOfBoundsException("Provided correctAnswer index is not within range of answers list");
        } else {
            this.correctAnswer = correctAnswer;
        }
    }

    public int answersCount() {
        return answers.size();
    }
}
