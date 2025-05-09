package com.example.quizapp.controller;

import com.example.quizapp.HelloApplication;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.QuizAttempt;

import com.example.quizapp.model.QuizQuestion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class QuestionsController {
    @FXML
    private Label quizNameLabel;
    @FXML
    private Label questionsAnsweredTracker;
    @FXML
    private Button submitQuizButton;
    @FXML
    private VBox questionsContainer;
    @FXML
    private Button dashboardButton;

    private static QuizAttempt quizAttempt;
    private ArrayList<VBox> displayedQuestions;

    public void initialize() {

    }

    public static QuizAttempt getQuizAttempt() {
        return quizAttempt;
    }

    private void updateTracker() {
        questionsAnsweredTracker.setText(
                "Answered: " + quizAttempt.answeredQuestionsCount() + "/" + quizAttempt.getQuiz().getLength()
        );
    }

    private VBox createQuestionDisplay(int questionIndex, QuizQuestion question) {
        VBox questionDisplay = new VBox();
        ObservableList<Node> observableList = questionDisplay.getChildren();

        Label questionNumberLabel = new Label("Question " + (questionIndex + 1));
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
            radioButton.setUserData(i);
            observableList.add(radioButton);
            c++;
        }

        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle old_toggle, Toggle new_toggle) {
                if (radioGroup.getSelectedToggle() != null) {
                    quizAttempt.setSelectedAnswer(questionIndex, (int)radioGroup.getSelectedToggle().getUserData());
                } else {
                    quizAttempt.setSelectedAnswer(questionIndex, -1);
                }
                updateTracker();
            }
        });

        questionDisplay.setStyle("-fx-background-color: #dddddd");
        questionDisplay.setSpacing(5);
        questionDisplay.setPadding(new Insets(10));

        return questionDisplay;
    }

    private void loadQuestions() {
        ObservableList<Node> observableList = questionsContainer.getChildren();
        for (int i = 0; i < quizAttempt.getQuiz().getLength(); i++) {
            observableList.add(createQuestionDisplay(i, quizAttempt.getQuiz().getQuestion(i)));
        }
    }

    public void setQuiz(Quiz quiz) { // must be called before switching to questions page
        quizAttempt = new QuizAttempt(quiz);
        quizNameLabel.setText(quiz.getQuizName());
        updateTracker();
        loadQuestions();
    }

    @FXML
    private void onSubmit() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm submission");
        alert.setHeaderText(null);
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Submit");
        if (quizAttempt.answeredQuestionsCount() < quizAttempt.getQuiz().getLength()) {
            alert.setContentText(
                    "You still have "
                    + (quizAttempt.getQuiz().getLength() - quizAttempt.answeredQuestionsCount())
                    + " unanswered questions.\n"
                    + "Unanswered questions will be marked incorrect.\n"
                    + "\nSubmit anyway?");
        } else {
            alert.setContentText("Are you sure you want to submit?");
        }
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get() == ButtonType.OK) {
            // Add result to database
            // Move to results page
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("results-view.fxml"));
            Scene resultsPage = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
            Stage stage = (Stage) submitQuizButton.getScene().getWindow();
            stage.setScene(resultsPage);
            stage.setTitle("Quiz Results");
        }
    }

    @FXML
    private void onDashboardButtonPressed() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit quiz?");
        alert.setHeaderText(null);
        ((Button) alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Exit");
        alert.setContentText(
                "Your progress will not be saved.\nAre you sure you want to exit?"
        );
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get() == ButtonType.OK) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/quizapp/Dashboard/Dashboard.fxml"));
            Scene dashboardPage = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
            Stage stage = (Stage) dashboardButton.getScene().getWindow();
            stage.setScene(dashboardPage);
            stage.setTitle("Dashboard");
        }
    }

}
