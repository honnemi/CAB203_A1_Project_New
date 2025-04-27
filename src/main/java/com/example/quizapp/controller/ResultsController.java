package com.example.quizapp.controller;

import com.example.quizapp.HelloApplication;
import com.example.quizapp.model.QuizAttempt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.ScrollPane.ScrollBarPolicy.*;

public class ResultsController {
    @FXML
    private Label currentResult;
    @FXML
    private ProgressIndicator resultGraph;
    @FXML
    private ScrollPane questions;
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

        // Get list of questions for current quiz attempt
        /*ArrayList<QuizQuestion> questionsList = currentAttempt.getQuiz().getQuestions();

        // Set up scroll pane to only scroll vertically as needed
        questions.setHbarPolicy(NEVER);
        questions.setVbarPolicy(AS_NEEDED);
        questions.setMaxHeight(500);

        // Create container to group all questions
        VBox allQuestions = new VBox();

        // Loop over list of questions to display each one
        for (int i = 1; i <= questionsList.toArray().length; i++) {

            QuizQuestion currentQuestion = currentAttempt.getQuiz().getQuestion(i);
            VBox questionContainer = new VBox();

            // Access and display question number and text for current question
            Label questionNumber = new Label("Question" + (i + 1));
            Label question = new Label(currentQuestion.getQuestionText());

            // Group both into a container for each question
            questionContainer.getChildren().addAll(questionNumber, question);

            // Group all questions into one container
            allQuestions.getChildren().addAll(questionContainer);
            allQuestions.setSpacing(20);
            allQuestions.setPadding(new Insets(10, 10, 10, 10));
        }

        // Set larger container as content of scroll pane
        questions.setContent(allQuestions);*/

        questions.setHbarPolicy(NEVER);
        questions.setVbarPolicy(AS_NEEDED);
        questions.setMaxHeight(500);
        VBox allQuestions = new VBox();

        // Example code
        for (int i = 1; i <= 4; i++) {
            VBox questionContainer = new VBox();
            Label questionNumber = new Label("Question " + (i + 1));
            Label question = new Label("What is " + i + " + 1?");
            questionContainer.getChildren().addAll(questionNumber, question);
            allQuestions.setSpacing(20);
            allQuestions.setPadding(new Insets(10, 10, 10, 10));
            allQuestions.getChildren().addAll(questionContainer);
        }

        questions.setContent(allQuestions);
    }

    @FXML
    private void toQuestionDetails() throws IOException {
        Stage stage = (Stage) questionDetailsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("question-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        stage.setScene(scene);
    }

    @FXML
    private void backToQuiz() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("questions-view.fxml"));
        Scene quizPage = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        Stage stage = (Stage) retakeQuizButton.getScene().getWindow();
        stage.setScene(quizPage);
        stage.setTitle("Quiz");
    }

    @FXML
    private void exitResults() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Dashboard.fxml"));
        Scene dashboardPage = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.setScene(dashboardPage);
        stage.setTitle("Dashboard");
    }

    @FXML
    private void toProgressReport() throws IOException {

    }
}
