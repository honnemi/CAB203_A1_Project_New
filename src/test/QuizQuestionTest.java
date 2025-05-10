import com.example.quizapp.model.QuizQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class QuizQuestionTest {

    private QuizQuestion question;
    private final String questionText = "What is 2 + 2?";
    private final ArrayList<String> answers = new ArrayList<>(Arrays.asList("3", "4", "5", "6"));
    private final int correctIndex = 1;

    @BeforeEach
    public void setUp() {
        question = new QuizQuestion(questionText, answers, correctIndex);
    }
    @Test
    public void testGetQuestionText() {
        setUp();
        assertEquals(questionText, question.getQuestionText());
    }
    @Test
    public void testSetQuestionText() {
        setUp();
        question.setQuestionText("New question?");
        assertEquals("New question?", question.getQuestionText());
    }
    @Test
    public void testGetAnswers() {
        setUp();
        assertEquals(answers, question.getAnswers());
    }
    @Test
    public void testSetAnswersValid() {
        setUp();
        ArrayList<String> newAnswers = new ArrayList<>(Arrays.asList("Yes", "No"));
        question.setAnswers(newAnswers);
        assertEquals(newAnswers, question.getAnswers());
    }
    @Test
    public void testSetAnswersInvalid() {
        setUp();
        assertThrows(IllegalArgumentException.class, () -> {
            question.setAnswers(new ArrayList<>());
        });
    }
    @Test
    public void testGetAnswer() {
        setUp();
        assertEquals("4", question.getAnswer(1));
    }
    @Test
    public void testSetAnswer() {
        setUp();
        question.setAnswer(0, "Two");
        assertEquals("Two", question.getAnswer(0));
    }
    @Test
    public void testGetCorrectAnswer() {
        setUp();
        assertEquals(correctIndex, question.getCorrectAnswer());
    }
    @Test
    public void testSetCorrectAnswerValid() {
        setUp();
        question.setCorrectAnswer(2);
        assertEquals(2, question.getCorrectAnswer());
    }
    @Test
    public void testSetCorrectAnswerInvalid() {
        setUp();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            question.setCorrectAnswer(10);
        });
    }
    @Test
    public void testGetAnswersCount() {
        setUp();
        assertEquals(4, question.getAnswersCount());
    }
    @Test
    public void testIsCorrectTrue() {
        setUp();
        assertTrue(question.isCorrect(correctIndex));
    }
    @Test
    public void testIsCorrectFalse() {
        setUp();
        assertFalse(question.isCorrect(0));
    }
}
