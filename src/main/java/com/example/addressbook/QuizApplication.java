package com.example.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class QuizApplication extends Application {
    // Constants defining the window title and size
    public static final String TITLE = "TutorWorm";
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 640;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        InputStream stream = new FileInputStream("images/tutorworm_sprite.png");
        Image img = new Image(stream);
        stage.getIcons().add(img);
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}