import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.QuizQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {

    private static final String quizName = "Graphs";
    private static final String topic = "Math";
    private static final String difficulty = "easy";

    private static final String newQuizName = "Ancient Greece";
    private static final String newTopic = "History";
    private static final String newDifficulty = "medium";

    private static final String invalidDifficulty = "extreme";

    private Quiz quiz;

    @BeforeEach
    public void setUp() {
        quiz = new Quiz(quizName, topic, difficulty);
    }

    @Test
    public void testGetQuizName() {
        setUp();
        assertEquals(quizName, quiz.getQuizName());
    }

    @Test
    public void testSetQuizName() {
        setUp();
        quiz.setQuizName(newQuizName);
        assertEquals(newQuizName, quiz.getQuizName());
    }

    @Test
    public void testGetTopic() {
        setUp();
        assertEquals(topic, quiz.getTopic());
    }

    @Test
    public void testSetTopic() {
        setUp();
        quiz.setTopic(newTopic);
        assertEquals(newTopic, quiz.getTopic());
    }

    @Test
    public void testGetDifficulty() {
        setUp();
        assertEquals(difficulty, quiz.getDifficulty());
    }

    @Test
    public void testSetDifficulty() {
        setUp();
        quiz.setDifficulty(newDifficulty);
        assertEquals(newDifficulty, quiz.getDifficulty());
    }

    /*@Test
    public void testInvalidDifficulty() {
        Exception exception = new IllegalArgumentException("Unknown difficulty: '" + difficulty + "'. Difficulty must be 'easy', 'medium', or 'hard'.");
        assertThrows(exception, quiz.setDifficulty(invalidDifficulty));
    }*/

    @Test
    public void testGetQuestions() {
        setUp();
        assertNotNull(quiz.getQuestions());
    }

    @Test
    public void testSetQuestions() {
        setUp();
        ArrayList<QuizQuestion> questionsList = new ArrayList<>();
        assertEquals(questionsList, quiz.getQuestions());
    }

    @Test
    public void testGetQuestion() {
        setUp();
        QuizQuestion question = new QuizQuestion();
        quiz.addQuestion(question);
        assertNotNull(quiz.getQuestion(0));
    }

    @Test
    public void testAddQuestion() {
        setUp();
        QuizQuestion question = new QuizQuestion();
        quiz.addQuestion(question);
        assertEquals(question, quiz.getQuestion(0));
    }

    @Test
    public void testSetQuestion() {
        setUp();
        QuizQuestion question = new QuizQuestion();
        QuizQuestion question2 = new QuizQuestion();
        quiz.addQuestion(question);
        quiz.setQuestion(0, question2);
        assertEquals(question2, quiz.getQuestion(0));
    }

    @Test
    public void testGetLengthListEmpty() {
        setUp();
        assertEquals(0, quiz.getLength());
    }

    @Test
    public void testGetLengthListNotEmpty() {
        setUp();
        QuizQuestion question = new QuizQuestion();
        quiz.addQuestion(question);
        assertEquals(1, quiz.getLength());
    }
}