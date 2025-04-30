import com.example.quizapp.model.quizAppAlert;

import javafx.scene.control.Alert;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class QuizAppAlertTest{

    @Test
    public void testQuizAppAlert() throws IOException {
        quizAppAlert testAlert = new quizAppAlert();
        Alert alert = testAlert.createAlert("Test Title", "Test Header", "Test Content");

        assertEquals(Alert.AlertType.WARNING, alert.getAlertType());
        assertEquals("Test Title", alert.getTitle());
        assertEquals("Test Header", alert.getHeaderText());
        assertEquals("Test Content", alert.getContentText());
        assertNotNull(alert.getGraphic());
    }

}