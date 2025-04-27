package com.example.quizapp.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class SettingsController {

    @FXML private Button accountButton;
    @FXML private Button personalisationButton;
    @FXML private Button notificationsButton;
    @FXML private Button logoutButton;

    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleLogout() {
        System.out.println("Logout clicked!");
    }

    @FXML
    private void handleAccount() {
        System.out.println("Account tab clicked");
    }

    @FXML
    private void handlePersonalisation() {
        System.out.println("Personalisation tab clicked");
    }

    @FXML
    private void handleNotifications() {
        System.out.println("Notifications tab clicked");
    }

    @FXML
    private void handleDifficulty() {
        System.out.println("Difficulty tab clicked");
    }

    @FXML
    private void handleChangePicture() {
        System.out.println("Change picture clicked");
    }

    @FXML
    private void handleChangePassword() {
        System.out.println("Change password clicked");
    }

    public void handleChangeUsername(ActionEvent actionEvent) {
        System.out.println("Change username clicked");
    }

    public void handleChangeEmail(ActionEvent actionEvent) {
        System.out.println("Change email clicked");
    }



}
