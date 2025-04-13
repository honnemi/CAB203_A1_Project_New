package com.example.addressbook.model;

import java.util.Arrays;

public class QuizAttempt {
    private final Quiz quiz;
    private int[] selectedAnswers; // index of selected answer in answers list for each question. -1 means no answer selected.

    public QuizAttempt(Quiz quiz) {
        this.quiz = quiz;
        this.selectedAnswers = new int[quiz.getLength()];
        Arrays.fill(selectedAnswers, -1);
    }

    public String getQuizName() {
        return quiz.getQuizName();
    }

    public int[] getSelectedAnswers() {
        return selectedAnswers;
    }

    public int getSelectedAnswer(int questionIndex) {
        return selectedAnswers[questionIndex];
    }
    public void setSelectedAnswer(int questionIndex, int selectedAnswer) throws IndexOutOfBoundsException{
        if (selectedAnswer >= quiz.getQuestions().get(questionIndex).getAnswersCount() || selectedAnswer < -1) {
            throw new IndexOutOfBoundsException("Provided selectedAnswer index is not within range of answers list for provided questionIndex");
        } else {
            selectedAnswers[questionIndex] = selectedAnswer;
        }
    }

    public int answeredQuestionsCount() {
        int count = 0;
        for (int answer : selectedAnswers) {
            if (answer != -1) count++;
        }
        return count;
    }

    public boolean answerIsCorrect(int questionIndex) {
        return selectedAnswers[questionIndex] == quiz.getQuestions().get(questionIndex).getCorrectAnswer();
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < quiz.getLength(); i++) {
           if (answerIsCorrect(i)) {
               score++;
           }
        }
        return score;
    }
}
