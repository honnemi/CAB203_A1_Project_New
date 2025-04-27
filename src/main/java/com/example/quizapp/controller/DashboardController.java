package com.example.quizapp.controller;

import com.example.quizapp.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    private Button settingsButton;
    @FXML
    private VBox addQuizBox;

    @FXML
    public void initialize() {
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
    }
    @FXML
    private void settingsPressed() throws IOException {
        try {
            Stage stage = (Stage) settingsButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settingsProfile-View.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
            stage.setScene(scene);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
