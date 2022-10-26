package rectangle.analyzer.service;

import org.junit.jupiter.api.Test;
import rectangle.analyzer.model.Point;
import rectangle.analyzer.model.Rectangle;
import rectangle.analyzer.exception.InvalidRectangleException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static rectangle.analyzer.service.RectangleValidator.assertValid;

class RectangleValidatorTest {

    @Test
    void testAssertValidFalseThrowsException() {
        Rectangle r = new Rectangle(new Point(5, 5), new Point(1, 1));
        try {
            assertValid(r);
            fail();
        } catch (InvalidRectangleException e) {
            assertEquals("Invalid rectangle. Check the input and ensure "
                    + "valid lower left and upper right points.\n"
                    + "Example: \"0,0;2.5,2\" \"1.8,1;3,3\"", e.getMessage());
        }
    }

    @Test
    void testAssertValidTrueReturnsRectangle() {
        Rectangle r = new Rectangle(new Point(0, 0), new Point(1, 1));

        assertEquals(r, assertValid(r));
    }
}
