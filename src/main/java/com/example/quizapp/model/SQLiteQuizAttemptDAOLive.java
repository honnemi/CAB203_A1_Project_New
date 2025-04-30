package com.example.quizapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SQLiteQuizAttemptDAOLive {
    private Connection connection;

    public SQLiteQuizAttemptDAOLive() {
        connection = SQLiteUserConnectionLive.getInstance();
        createTable();
    }

    private void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS quiz_attempts ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "quiz_id INTEGER NOT NULL,"
                    + "FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE"
                    + "selected_answers VARCHAR NOT NULL,"
                    + "user_id VARCHAR NOT NULL"
                    + "FOREIGN KEY (user_id) REFERENCES users(userName) ON DELETE CASCADE"
                    + ")";
            statement.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void addQuizAttempt(QuizAttempt quizAttempt) {
//        try {
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO quiz_attempts (userName, password, email) VALUES (?, ?, ?)");
//            statement.setString(1, user.getUserName());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getEmail());
//            statement.executeUpdate();
//            // Set the id of the new contact
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void updateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET email = ?, password = ? WHERE userName = ?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getUserName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE userName = ?");
            statement.setString(1, user.getUserName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE userName = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                User user = new User(userName, password, email);
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                User user = new User(userName, password, email);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean checkUserPresent(String userName){
        List<User> users = getAllUsers();
        int userLength = users.size();
        for (int i=0 ; i < userLength; i++){
            if(Objects.equals(users.get(i).getUserName(), userName)){
                return true;
            }
        }
        return false;

    }
}

