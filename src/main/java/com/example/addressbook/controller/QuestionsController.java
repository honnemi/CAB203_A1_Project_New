package com.example.addressbook.controller;

import com.example.addressbook.model.Quiz;
import com.example.addressbook.model.QuizAttempt;

import com.example.addressbook.model.QuizQuestion;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class QuestionsController {
    @FXML
    private Label quizNameLabel;
    @FXML
    private Label questionsAnsweredTracker;
    @FXML
    private Button submitQuizButton;
    @FXML
    private VBox questionsContainer;

    private QuizAttempt quizAttempt;
    private ArrayList<VBox> displayedQuestions;


    public void initialize() {

    }

    public void updateTracker() {
        questionsAnsweredTracker.setText(
                "Answered: " + quizAttempt.answeredQuestionsCount() + "/" + quizAttempt.getQuiz().getLength()
        );
    }

    private VBox createQuestionDisplay(int questionNumber, QuizQuestion question) {
        VBox questionDisplay = new VBox();
        ObservableList<Node> observableList = questionDisplay.getChildren();

        Label questionNumberLabel = new Label("Question " + questionNumber);
        questionNumberLabel.setFont(new Font(14));
        Label questionTextLabel = new Label(question.getQuestionText());
        questionTextLabel.setFont(new Font(14));

        observableList.addAll(questionNumberLabel, questionTextLabel);
        ToggleGroup radioGroup = new ToggleGroup();
        char c = 'A';
        for (int i = 0; i < question.getAnswersCount(); i++) {
            RadioButton radioButton = new RadioButton(c + ") " + question.getAnswer(i));
            radioButton.setFont(new Font(14));
            radioButton.setToggleGroup(radioGroup);
            observableList.add(radioButton);
            c++;
        }

        questionDisplay.setStyle("-fx-background-color: #dddddd");
        questionDisplay.setSpacing(5);
        questionDisplay.setPadding(new Insets(10));

        return questionDisplay;
    }

    private void loadQuestions() {
        ObservableList<Node> observableList = questionsContainer.getChildren();
        for (int i = 0; i < quizAttempt.getQuiz().getLength(); i++) {
            observableList.add(createQuestionDisplay(i + 1, quizAttempt.getQuiz().getQuestion(i)));
        }
    }

    public void loadQuiz(Quiz quiz) { // start a new quiz attempt
        quizAttempt = new QuizAttempt(quiz);
        quizNameLabel.setText(quizAttempt.getQuizName());
        updateTracker();
        loadQuestions();
    }
    public void loadQuiz(QuizAttempt quizAttempt) { // load an existing quiz attempt
        this.quizAttempt = quizAttempt;
        quizNameLabel.setText(quizAttempt.getQuizName());
        updateTracker();
        loadQuestions();
    }







}
