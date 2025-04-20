package com.example.addressbook;

import com.example.addressbook.controller.ProgressReportController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    // Constants defining the window title and size
    public static final String TITLE = "Address Book";
    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
//        stage.setTitle(TITLE);
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("progress-report-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), WIDTH, HEIGHT);
        ProgressReportController controller = fxmlLoader.getController();
        controller.setLineChartData(ProgressReportController.generateQuizAttempts(5));
        stage.setTitle(TITLE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}