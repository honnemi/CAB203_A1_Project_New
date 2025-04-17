package com.example.quizapp.controller;

import com.example.quizapp.model.QuizAttempt;
import com.example.quizapp.model.QuizQuestion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ResultsController {
    @FXML
    private Label CurrentResult;
    @FXML
    private ProgressIndicator ResultGraph;
    @FXML
    private VBox Questions;
    @FXML
    private Button RetakeQuizButton;
    @FXML
    private Button ProgressReportButton;
    @FXML
    private Button ViewDetailsButton;
    @FXML
    private Button ExitButton;

    @FXML
    private void initialize() {
        // Code to display score for this current quiz attempt
//        int score = currentAttempt.getScore();
//        int quizLength = currentAttempt.getQuiz().getLength();
//
//        CurrentResult.setText(Integer.toString(score) + "/" + Integer.toString(quizLength));
//        ResultGraph.setProgress(score / quizLength);

        // Example code
        CurrentResult.setText("5/10");
        ResultGraph.setProgress(0.5);

        // Code to display list of questions for this current quiz attempt
//        ArrayList<QuizQuestion> questionsList = currentAttempt.getQuiz().getQuestions();


//        for (int i = 0; i <= questionsList; i++) {
//            QuizQuestion currentQuestion = questionsList.getQuestion(i);
//            VBox questionContainer = new VBox();
//            Label questionNumber = new Label("Question" + Integer.toString(i + 1));
//            Label question = new Label(currentQuestion.getQuestionText());
//            questionContainer.getChildren().addAll(questionNumber, question);
//            Questions.getChildren().addAll(questionContainer);
//        }

        // Example code
        for (int i = 0; i <= 3; i++) {
            VBox questionContainer = new VBox();
            Label questionNumber = new Label("Question " + Integer.toString(i + 1));
            Label question = new Label("What is " + Integer.toString(i) + " + 1?");
            questionContainer.getChildren().addAll(questionNumber, question);
            Questions.getChildren().addAll(questionContainer);
        }
    }
}
