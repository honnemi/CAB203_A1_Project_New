package com.example.quizapp.model;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;



public class quizAppAlert {

        public void alert(String title, String header, String content) throws IOException {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Image image = new Image(getClass().getResource("/com/example/images/tutorwormdefault.png").toString());
            ImageView imageView = new ImageView();
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);
            imageView.setPreserveRatio(true);
            imageView.setImage(image);
            alert.setGraphic(imageView);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);

            alert.showAndWait();
        }
}