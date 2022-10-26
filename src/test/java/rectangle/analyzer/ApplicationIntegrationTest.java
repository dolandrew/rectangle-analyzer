package rectangle.analyzer;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationIntegrationTest {

    private static final LogCaptor LOG_CAPTOR = LogCaptor.forClass(
            Application.class);

    @AfterEach
    public void clearLogs() {
        LOG_CAPTOR.clearLogs();
    }

    @Test
    void testIntersects() {
        Application.main(new String[]{"0,0;2,2", "1,1;3,3"});

        assertSingleInfoMessage("Rectangle A intersects "
                + "Rectangle B.");
    }

    @Test
    void testContains() {
        Application.main(new String[]{"0,0;5,5", "1,1;3,3"});

        assertSingleInfoMessage("Rectangle A contains "
                + "Rectangle B.");
    }

    @Test
    void testContainsInverse() {
        Application.main(new String[]{"1,1;3,3", "0,0;5,5"});

        assertSingleInfoMessage("Rectangle A is contained by "
                + "Rectangle B.");
    }

    @Test
    void testIsAdjacent() {
        Application.main(new String[]{"0,0;2,2", "0.5,-2;1.5,0"});

        assertSingleInfoMessage("Rectangle A is adjacent to "
                + "Rectangle B.");
    }

    @Test
    void testNoRelationship() {
        Application.main(new String[]{"0,0;2,2", "3,3;5,5"});

        assertSingleInfoMessage("Rectangle A has no relationship"
                + " to Rectangle B.");
    }

    @Test
    void testInvalidInput() {
        Application.main(new String[]{"cats,0;2,2", "1,1;3,3"});

        assertSingleErrorMessage();
    }

    private static void assertSingleInfoMessage(final String expectedMessage) {
        List<String> logs = LOG_CAPTOR.getInfoLogs();

        assertEquals(1, logs.size());
        assertEquals(expectedMessage, logs.get(0));
    }

    private static void assertSingleErrorMessage() {
        List<String> logs = LOG_CAPTOR.getErrorLogs();

        assertEquals(1, logs.size());
        assertEquals("Error parsing input. Check that "
                + "input contains numeric pairs with valid delimiters.\n"
                + "Example: \"0,0;2.5,2\" \"1.8,1;3,3\"", logs.get(0));
    }
}
