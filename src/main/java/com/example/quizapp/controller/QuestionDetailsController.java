package com.example.quizapp.controller;

import com.example.quizapp.QuizApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestionDetailsController {
    @FXML
    private Label quizName;
    @FXML
    private Button backToResultsButton;
    @FXML
    private VBox questions;

    @FXML
    private void initialize() {

        // Code to display quiz name
        // String name = currentAttempt.getQuiz.getQuizName();
        String name = "Quiz Name Here";
        quizName.setText(name);

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
            questions.getChildren().addAll(questionContainer);
        }
    }

    @FXML
    private void backToResults() throws IOException {
        Stage stage = (Stage) backToResultsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("results-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), QuizApplication.WIDTH, QuizApplication.HEIGHT);
        stage.setScene(scene);
    }
}
