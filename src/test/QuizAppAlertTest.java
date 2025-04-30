

public class QuizAppAlertTest{

    @Test
    public void testQuizAppAlert() throws IOException {
        QuizAppAlert quizAppAlert = new QuizAppAlert();
        Alert alert = quizAppAlert.createAlert("Test Title", "Test Header", "Test Content");

        assertEquals(Alert.AlertType.WARNING, alert.getAlertType());
        assertEquals("Test Title", alert.getTitle());
        assertEquals("Test Header", alert.getHeaderText());
        assertEquals("Test Content", alert.getContentText());
        assertNotNull(alert.getGraphic());
    }

}