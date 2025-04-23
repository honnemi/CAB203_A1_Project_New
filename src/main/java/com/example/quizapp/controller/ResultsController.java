package com.example.quizapp.controller;

import com.example.quizapp.QuizApplication;
import com.example.quizapp.model.QuizAttempt;
import com.example.quizapp.model.QuizQuestion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ResultsController {
    @FXML
    private Label currentResult;
    @FXML
    private ProgressIndicator resultGraph;
    @FXML
    private VBox questions;
    @FXML
    private Button retakeQuizButton;
    @FXML
    private Button progressReportButton;
    @FXML
    private Button questionDetailsButton;
    @FXML
    private Button exitButton;

    // Should be able to access the field of another class which holds the current quiz instance?
    private QuizAttempt currentAttempt;

    @FXML
    private void initialize() {

        // Code to display score for this current quiz attempt
        /*

        // Access score and quiz length for current quiz attempt
        int score = currentAttempt.getScore();
        int quizLength = currentAttempt.getQuiz().getLength();

        // Display score out of the quiz length
        currentResult.setText(Integer.toString(score) + "/" + Integer.toString(quizLength));

        // Update graph to represent score
        resultGraph.setProgress(score / quizLength);*/

        // Example code
        currentResult.setText("5/10");
        resultGraph.setProgress(0.5);

        // Code to display list of questions for this current quiz attempt
        /*
        // Get list of questions for current quiz attempt
        ArrayList<QuizQuestion> questionsList = currentAttempt.getQuiz().getQuestions();

        // Loop over list of questions to display each one
        for (int i = 1; i <= questionsList.toArray().length; i++) {

            QuizQuestion currentQuestion = currentAttempt.getQuiz().getQuestion(i);
            VBox questionContainer = new VBox();

            // Access and display question number and text for current question
            Label questionNumber = new Label("Question" + (i + 1));
            Label question = new Label(currentQuestion.getQuestionText());

            // Group both into a container
            questionContainer.getChildren().addAll(questionNumber, question);

            // Add the above to container defined in fxml file to update the page
            questions.getChildren().addAll(questionContainer);
        }*/

        // Example code
        for (int i = 1; i <= 4; i++) {
            VBox questionContainer = new VBox();
            Label questionNumber = new Label("Question " + (i + 1));
            Label question = new Label("What is " + i + " + 1?");
            questionContainer.getChildren().addAll(questionNumber, question);
            questions.getChildren().addAll(questionContainer);
        }
    }

    @FXML
    private void toQuestionDetails() throws IOException {
        Stage stage = (Stage) questionDetailsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("question-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), QuizApplication.WIDTH, QuizApplication.HEIGHT);
        stage.setScene(scene);
    }
}
