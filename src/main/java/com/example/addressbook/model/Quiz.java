package com.example.addressbook.model;

import java.util.ArrayList;

public class Quiz {
    private String quizName;
    private String topic;
    private ArrayList<QuizQuestion> questions = new ArrayList<>();

    public Quiz() {
        this.quizName = "Quiz Name";
        this.topic = "Quiz Topic";
    }
    public Quiz(String quizName) {
        this.quizName = quizName;
        this.topic = "Quiz Topic";
    }
    public Quiz(String quizName, String topic) {
        this.quizName = quizName;
        this.topic = topic;
    }

    public String getQuizName() {
        return quizName;
    }
    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ArrayList<QuizQuestion> getQuestions() {
        return questions;
    }
    public void setQuestions(ArrayList<QuizQuestion> questions) {
        this.questions = questions;
    }

    public QuizQuestion getQuestion(int questionIndex) {
        return questions.get(questionIndex);
    }
    public void setQuestion(int questionIndex, QuizQuestion question) {
        questions.set(questionIndex, question);
    }
    public void setQuestion(int questionIndex, String questionText, ArrayList<String> answers, int correctAnswer) {
        questions.set(questionIndex, new QuizQuestion(questionText, answers, correctAnswer));
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
