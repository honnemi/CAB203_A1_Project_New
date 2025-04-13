package com.example.addressbook.model;

import java.util.ArrayList;

public class Quiz {
    private String quizName;
    private ArrayList<QuizQuestion> questions = new ArrayList<>();

    public Quiz() {
        this.quizName = "Quiz Name";
    }
    public Quiz(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizName() {
        return quizName;
    }
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public ArrayList<QuizQuestion> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<QuizQuestion> questions) {
        this.questions = questions;
    }

    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }
    public void addQuestion(String questionText, ArrayList<String> answers, int correctAnswer) {
        questions.add(new QuizQuestion(questionText, answers, correctAnswer));
    }

    public int getLength() {
        return questions.size();
    }
}
