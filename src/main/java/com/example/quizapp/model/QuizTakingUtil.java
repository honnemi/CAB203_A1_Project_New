package com.example.quizapp.model;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizTakingUtil {
    // method for taking quiz through CLI (no input validation -- invalid input will cause exception)
    public static void attemptQuizCLI(QuizAttempt attempt) {
        System.out.println(attempt.getQuizName());
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < attempt.getQuiz().getLength(); i++) {
            QuizQuestion currentQ = attempt.getQuiz().getQuestion(i);
            System.out.println(currentQ.getQuestionText());
            for (int j = 0; j < currentQ.getAnswersCount(); j++) {
                System.out.println(j + ". " + currentQ.getAnswer(j));
            }
            System.out.print("Enter answer index: ");
            int input = scanner.nextInt();
            attempt.setSelectedAnswer(i, input);
            if (input == currentQ.getCorrectAnswer()) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
        System.out.println("Score: " + attempt.getScore() + " out of " + attempt.getQuiz().getLength());
        System.out.println("= " + attempt.getScorePercentage() + "%");
    }

    // returns a quiz with default values with specified number of questions
    public static Quiz generateDefaultQuiz(int numQuestions) {
        Quiz quiz = new Quiz();
        for (int i = 0; i < numQuestions; i++) {
            quiz.addQuestion(new QuizQuestion());
        }
        return quiz;
    }

    // gets the ai response and turns it into questions
    public static Quiz parseAIResponse(String response, String quizName, String topic, String difficulty) {
        Quiz quiz = new Quiz(quizName, topic, difficulty);
        Scanner scanner = new Scanner(response);
        String line;
        String questionText = null;
        ArrayList<String> options = new ArrayList<>();
        int correctIndex = 0;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine().trim();

            if (line.matches("Q\\d+:.*")) {
                // a new question is starting
                if (questionText != null && !options.isEmpty()) {
                    quiz.addQuestion(new QuizQuestion(questionText, options, correctIndex));
                    options = new ArrayList<>();
                }
                questionText = line.substring(line.indexOf(":") + 1).trim();

            } else if (line.matches("[A-D]\\).*")) {
                options.add(line.substring(3).trim()); // remove "A) " etc.

            } else if (line.toLowerCase().startsWith("answer:")) {
                String correctLetter = line.split(":")[1].trim();
                correctIndex = correctLetter.charAt(0) - 'A';
            }
        }

        // adding the final question
        if (questionText != null && !options.isEmpty()) {
            quiz.addQuestion(new QuizQuestion(questionText, options, correctIndex));
        }

        return quiz;
    }
}

