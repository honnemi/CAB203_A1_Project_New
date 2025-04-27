package com.example.quizapp.model;

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
