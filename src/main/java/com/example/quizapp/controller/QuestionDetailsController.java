package com.example.quizapp.controller;

import com.example.quizapp.QuizApplication;
import com.example.quizapp.model.QuizAttempt;
import com.example.quizapp.model.QuizQuestion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionDetailsController {
    @FXML
    private Label quizName;
    @FXML
    private Button backToResultsButton;
    @FXML
    private VBox questions;

    // Should be able to access the field of another class which holds the current quiz instance?
    private QuizAttempt currentAttempt;

    @FXML
    private void initialize() {

        // Code to display quiz name
        /*String name = currentAttempt.getQuiz().getQuizName();
        quizName.setText(name);*/

        // Example code
        String name = "Quiz Name Here";
        quizName.setText(name);

        // Code to display list of questions for this current quiz attempt

        // Get list of questions for current quiz attempt
        /*ArrayList<QuizQuestion> questionsList = currentAttempt.getQuiz().getQuestions();

        // Loop over list of questions
        for (int i = 1; i <= questionsList.toArray().length; i++) {

            QuizQuestion currentQuestion = currentAttempt.getQuiz().getQuestion(i);
            VBox questionContainer = new VBox();
            VBox answerContainer = new VBox();
            HBox resultsContainer = new HBox();

            // Display and access question number and text for current question
            Label questionNumber = new Label("Question" + (i + 1));
            Label question = new Label(currentQuestion.getQuestionText());

            // Get index for the selected answer
            int selectedAnswer = currentAttempt.getSelectedAnswer(i);

            // Loop over answers for the current question
            for (int j = 1; j <= currentQuestion.getAnswersCount(); j ++) {

                // Display radio button with answer text
                RadioButton answerOption = new RadioButton(currentQuestion.getAnswer(j));

                // Mark the selected answer
                answerOption.setSelected(j == selectedAnswer);

                // Mark the correct answer
                answerOption.setSelected(currentAttempt.answerIsCorrect(i));

                // Disable radio buttons and display them normally (without default faded look)
                answerOption.setDisable(true);
                answerOption.setStyle("-fx-opacity: 1");
                answerOption.setPadding(new Insets(10, 0, 10, 0));

                // Group all answers into a container
                answerContainer.getChildren().add(answerOption);
            }

            // Display selected and correct answers in text
            int yourAnswer = currentAttempt.getSelectedAnswer(i);
            int correctAnswer = currentQuestion.getCorrectAnswer();
            Label yourAnswerLabel = new Label("Your answer: " + answerLetter(yourAnswer));
            Label correctAnswerLabel = new Label("Correct answer: " + answerLetter(correctAnswer));

            // Display horizontally instead of vertically
            resultsContainer.getChildren().addAll(yourAnswerLabel, correctAnswerLabel);
            resultsContainer.setSpacing(10);

            // Group all questions into a container
            questionContainer.getChildren().addAll(questionNumber, question, answerContainer);

            // Add the above to container defined in fxml file to update the page
            questions.getChildren().addAll(questionContainer);
            questions.setSpacing(10);
        }*/

        // Example code
        for (int i = 1; i <= 4; i++) {
            VBox questionContainer = new VBox();
            VBox answerContainer = new VBox();
            HBox results = new HBox();
            Label questionNumber = new Label("Question " + (i + 1));
            Label question = new Label("What is " + i + " + 1?");
            int answerSelectedCount = 0;
            for (int j = 1; j <= 4; j ++) {
                int selectedAnswer = (int) Math.round(Math.random() * 10);
                int isSelected = (int) Math.round(Math.random());
                RadioButton answerOption = new RadioButton(Integer.toString(selectedAnswer));
                if (answerSelectedCount != 2 && isSelected == 1) {
                    answerOption.setSelected(true);
                    answerSelectedCount++;
                }
                else {
                    answerOption.setSelected(false);
                }
                answerOption.setDisable(true);
                answerOption.setStyle("-fx-opacity: 1");
                answerOption.setPadding(new Insets(10, 0, 10, 0));
                answerContainer.getChildren().add(answerOption);
            }
            Label yourAnswerLabel = new Label("Your answer: ");
            Label correctAnswerLabel = new Label("Correct answer: ");
            results.getChildren().addAll(yourAnswerLabel, correctAnswerLabel);
            results.setSpacing(10);
            questionContainer.getChildren().addAll(questionNumber, question, answerContainer, results);
            questions.getChildren().addAll(questionContainer);
            questions.setSpacing(20);
        }
    }

    @FXML
    private void backToResults() throws IOException {
        Stage stage = (Stage) backToResultsButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("results-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), QuizApplication.WIDTH, QuizApplication.HEIGHT);
        stage.setScene(scene);
    }

    private String answerLetter(int answerIndex) {

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        return Character.toString(alphabet[answerIndex]);
    }
}
