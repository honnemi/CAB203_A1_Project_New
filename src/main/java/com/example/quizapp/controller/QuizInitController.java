package com.example.quizapp.controller;

import com.example.quizapp.HelloApplication;
import com.example.quizapp.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import static com.example.quizapp.model.QuizInitConfig.readLinesFromFile;

public class QuizInitController {

    @FXML
    private VBox uploadBox;
    @FXML
    private Label errorLabel;
    @FXML
    private Slider difficultySlider;
    @FXML
    private ToggleButton q1to10;
    @FXML
    private ToggleButton q10to20;
    @FXML
    private ToggleButton q20to30;
    @FXML
    private Button startQuizBtn;
    @FXML
    private Button backToDashboardBtn;
    @FXML
    private TextField topicField;



    private File selectedFile;
    private String questionRange;
    private String uploadedFileContent;
    private String fileContent;

    @FXML
    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        q1to10.setToggleGroup(group);
        q10to20.setToggleGroup(group);
        q20to30.setToggleGroup(group);
        errorLabel.setVisible(false);

        group.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                questionRange = ((ToggleButton) newToggle).getText();
            }
        });
        String difficultyLabel;
        double diffValue = difficultySlider.getValue();
        if (diffValue < 1.5) {
            difficultyLabel = "easy";
        } else if (diffValue < 2.5) {
            difficultyLabel = "medium";
        } else {
            difficultyLabel = "hard";
        }
        uploadBox.setOnMouseClicked((MouseEvent e) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choose Study Material File");
            selectedFile = fileChooser.showOpenDialog(uploadBox.getScene().getWindow());

            if (selectedFile != null) {
                errorLabel.setText("Selected: " + selectedFile.getName());
                errorLabel.setVisible(true);
                try {
                    uploadedFileContent = readLinesFromFile(selectedFile.getAbsolutePath());
                    System.out.println("\nUploaded File Content:\n" + uploadedFileContent);
                } catch (Exception error) {
                    error.printStackTrace();
                    errorLabel.setText("Error reading file.");
                }
            } else {
                errorLabel.setText("No file selected.");
                errorLabel.setVisible(true);
            }
        });

        startQuizBtn.setOnAction(e -> {
            if (selectedFile == null) {
                errorLabel.setText("Please upload a file first!");
                errorLabel.setVisible(true);
                return;
            }

            if (questionRange == null || questionRange.isEmpty()) {
                errorLabel.setText("Please select question range.");
                errorLabel.setVisible(true);
                return;
            }

            String topic = topicField.getText();
            if (topic == null || topic.trim().isEmpty()) {
                errorLabel.setText("Please enter a topic.");
                errorLabel.setVisible(true);
                return;
            }
            String prompt = "Create a " + questionRange + "-question quiz on " + topic +
                    " for high school students with " + difficultyLabel + " difficulty using this study material:\n\n" +
                    uploadedFileContent;
            String aiQuizResponse = com.example.quizapp.model.aiQuizGenerator.generateQuiz(prompt);
            System.out.println("AI Quiz Response:\n" + aiQuizResponse);

            Alert loading = new Alert(Alert.AlertType.INFORMATION);
            loading.setHeaderText("Generating Quiz...");
            loading.setContentText("Please wait while AI generates your quiz.");
            loading.getDialogPane().lookupButton(ButtonType.OK).setDisable(true); // Disable OK button
            loading.show();

            new Thread(() -> {
                String aiResponse = aiQuizGenerator.generateQuiz(prompt);
                String quizName = topicField.getText();
                String quizTopic = topicField.getText();
                String difficulty = String.valueOf(difficultySlider.getValue());

                Quiz quiz = QuizTakingUtil.parseAIResponse(aiResponse, quizName, quizTopic, difficulty);


                javafx.application.Platform.runLater(() -> {
                    loading.close();

                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("questions-view.fxml"));
                        Scene scene = new Scene(loader.load(), HelloApplication.WIDTH, HelloApplication.HEIGHT);

                        QuestionsController controller = loader.getController();
                        controller.setQuiz(quiz); // only call once, with parsed quiz

                        Stage stage = (Stage) startQuizBtn.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Quiz");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            }).start();
        });

        backToDashboardBtn.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/quizapp/Dashboard/Dashboard.fxml"));
                Scene dashboardScene = new Scene(loader.load(), 900, 600);
                Stage stage = (Stage) backToDashboardBtn.getScene().getWindow();
                stage.setScene(dashboardScene);
                stage.setTitle("Dashboard");
            } catch (Exception ex) {
                ex.printStackTrace();
                errorLabel.setText("Failed to return to dashboard.");
            }
        });
    }


//    private void storeQuizInit() {
//        double difficulty = difficultySlider.getValue();
//
//        QuizInitConfig config = new QuizInitConfig(selectedFile, difficulty, questionRange);
//        AppState.currentQuizConfig = config;
//
//        System.out.println("Quiz config stored:");
//        System.out.println("File: " + config.getUploadedFile().getName());
//        System.out.println("Difficulty: " + config.getDifficulty());
//        System.out.println("Questions: " + config.getQuestionRange());
//    }

}



