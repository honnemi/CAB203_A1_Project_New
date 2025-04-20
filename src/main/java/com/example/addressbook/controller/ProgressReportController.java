package com.example.addressbook.controller;

import com.example.addressbook.model.Quiz;
import com.example.addressbook.model.QuizAttempt;
import com.example.addressbook.model.QuizQuestion;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.util.concurrent.ThreadLocalRandom; // remove later

public class ProgressReportController {
    @FXML
    private Label quizTopicLabel;
    @FXML
    private LineChart lineChart;
    @FXML
    private TextArea commentsArea;
    @FXML
    private Button backButton;

    public void initialize() {
        lineChart.setLegendVisible(false);
        commentsArea.setText("""
Lorem ipsum dolor sit amet, consectetur adipiscing elit,
sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
Eget dolor morbi non arcu risus. Quis lectus nulla at volutpat diam
ut venenatis tellus in. Feugiat in fermentum posuere urna nec tincidunt
praesent semper. Turpis tincidunt id aliquet risus feugiat in.
Libero volutpat sed cras ornare. Facilisi morbi tempus iaculis urna.
Bibendum est ultricies integer quis auctor. Eu augue ut lectus arcu.
Tincidunt tortor aliquam nulla facilisi cras fermentum odio eu.
Gravida neque convallis a cras. Elit ut aliquam purus sit.
Suspendisse ultrices gravida dictum fusce ut placerat.
Integer feugiat scelerisque varius morbi enim nunc.
Amet justo donec enim diam vulputate ut pharetra.
Sapien pellentesque habitant morbi tristique.
Lorem sed risus ultricies tristique nulla aliquet.
Elementum nibh tellus molestie nunc non blandit massa.""");
    }

    @FXML
    private void onBackButtonPressed() {
        // go back to results page
    }

    public void setQuizTopicLabel(String topic) {
        quizTopicLabel.setText("Progress Report: " + topic);
    }

    public void setCommentsAreaText(String comments) {
        commentsArea.setText(comments);
    }

    public void setLineChartData(QuizAttempt[] quizAttempts) {
        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < quizAttempts.length; i++) {
            series.getData().add(new XYChart.Data(i + 1, quizAttempts[i].getScorePercentage()));
        }
        lineChart.getData().add(series);
    }

    // generates an array of quiz attempts for testing -- delete later
    public static QuizAttempt[] generateQuizAttempts(int numAttempts) {
        QuizAttempt[] quizAttempts = new QuizAttempt[numAttempts];
        Quiz quiz = new Quiz();
        for (int i = 0; i < 4; i++) {
            quiz.addQuestion(new QuizQuestion());
        }
        for (int i = 0; i < quizAttempts.length; i++) {
            QuizAttempt attempt = new QuizAttempt(quiz);
            for (int j = 0; j < attempt.getSelectedAnswers().length; j++) {
                attempt.setSelectedAnswer(j, ThreadLocalRandom.current().nextInt(-1,
                        attempt.getQuiz().getQuestion(j).getAnswersCount()));
            }
            quizAttempts[i] = attempt;
        }
        return quizAttempts;
    }
}
