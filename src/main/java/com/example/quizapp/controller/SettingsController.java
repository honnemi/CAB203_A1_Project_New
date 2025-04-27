package com.example.quizapp.controller;
import com.example.quizapp.HelloApplication;
import com.example.quizapp.model.quizAppAlert;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class SettingsController {

    @FXML public Button settingsBack;
    @FXML private Label messageBox;
    @FXML private Button accountButton;
    @FXML private Button personalisationButton;
    @FXML private Button notificationsButton;
    @FXML private Button logoutButton;

    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;


    public void settingsBackPressed(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/quizapp/Dashboard/Dashboard.fxml"));
            Scene dashboardScene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
            Stage stage = (Stage) settingsBack.getScene().getWindow();
            stage.setTitle("Dashboard");
            stage.setScene(dashboardScene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setTitle(HelloApplication.TITLE);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAccount() {
        setMessageBox("Account tab clicked", 2);
        quizAppAlert alert = new quizAppAlert();
        alert.alert("Alert title", "This is an alert", "Alert content");
    }

    @FXML
    private void handlePersonalisation() {
        setMessageBox("Personalisation tab clicked", 2);
    }

    @FXML
    private void handleNotifications() {
        setMessageBox("Notifications tab clicked", 2);
    }

    @FXML
    private void handleChangePassword() {
        setMessageBox("Change password clicked", 2);
    }

    public void handleChangeUsername(ActionEvent actionEvent) {
        setMessageBox("Change username clicked", 2);
    }

    public void handleChangeEmail(ActionEvent actionEvent) {
        setMessageBox("Change email clicked", 2);
    }

    public void setMessageBox(String message, Integer time){
        messageBox.setText(message);
        PauseTransition waiting = new PauseTransition(Duration.seconds(time));
        waiting.setOnFinished(event -> messageBox.setText(""));
        waiting.play();
    }


}
