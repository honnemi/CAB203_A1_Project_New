package com.example.quizapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    private VBox addQuizBox;
    @FXML
    private ComboBox<String> topicDropdown;
    @FXML
    private Button viewProgressBtn;
    @FXML
    private Hyperlink logoutLink;

    @FXML
    public void initialize() {
        // Existing AddQuizBox click listener
        addQuizBox.setOnMouseClicked((MouseEvent event) -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quizapp/quiz-init/quiz-init.fxml"));
                Scene quizInitScene = new Scene(loader.load(), 900, 600);
                Stage stage = (Stage) addQuizBox.getScene().getWindow();
                stage.setScene(quizInitScene);
                stage.setTitle("Quiz Initialisation");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        topicDropdown.getItems().addAll(
                "Math",
                "Science",
                "History",
                "Programming Basics"
        );

        viewProgressBtn.setOnAction(event -> {
            String selectedTopic = topicDropdown.getValue();
            if (selectedTopic != null) {
                System.out.println("Viewing progress for topic: " + selectedTopic);
                // openProgressPage(selectedTopic); -- adding a navigation for the selected topic progress page
            } else {
                System.out.println("Please select a topic first.");
            }
        });

        logoutLink.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quizapp/login-view.fxml"));
                Scene loginScene = new Scene(loader.load(), 900, 600);
                Stage stage = (Stage) logoutLink.getScene().getWindow();
                stage.setScene(loginScene);
                stage.setTitle("Login");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
