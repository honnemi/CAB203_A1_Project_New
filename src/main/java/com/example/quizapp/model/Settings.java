package com.example.quizapp.model;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class quizAppAlert {
        public void alert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Image image = new Image(getClass().getResourceAsStream("src.main.resources.com.example.images.tutorwormdefault.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        alert.setGraphic();
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Attention Needed");
        alert.setContentText("You must fix this issue!");

        alert.showAndWait();
        }


}