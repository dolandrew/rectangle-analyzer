package rectangle.analyzer.service;

import org.junit.jupiter.api.Test;
import rectangle.analyzer.exception.InvalidInputException;
import rectangle.analyzer.model.Point;
import rectangle.analyzer.model.Rectangle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static rectangle.analyzer.service.InputParser.parseInput;

class InputParserTest {

    @Test
    void testParseInput() {
        String[] args = {"1,2;3,4", "5,6;7,8"};

        List<Rectangle> result = parseInput(args);

        assertEquals(2, result.size());
        Rectangle a = result.get(0);
        Point aLowerLeft = a.lowerLeft();
        Point aUpperRight = a.upperRight();
        Rectangle b = result.get(1);
        Point bLowerLeft = b.lowerLeft();
        Point bUpperRight = b.upperRight();
        assertEquals(1, aLowerLeft.x());
        assertEquals(2, aLowerLeft.y());
        assertEquals(3, aUpperRight.x());
        assertEquals(4, aUpperRight.y());
        assertEquals(5, bLowerLeft.x());
        assertEquals(6, bLowerLeft.y());
        assertEquals(7, bUpperRight.x());
        assertEquals(8, bUpperRight.y());
    }

    @Test
    void testParseInputDecimal() {
        String[] args = {"1.5,2.5;3.5,4.5", "5.5,6.5;7.5,8.5"};

        List<Rectangle> result = parseInput(args);

        assertEquals(2, result.size());
        Rectangle a = result.get(0);
        Point aLowerLeft = a.lowerLeft();
        Point aUpperRight = a.upperRight();
        Rectangle b = result.get(1);
        Point bLowerLeft = b.lowerLeft();
        Point bUpperRight = b.upperRight();
        assertEquals(1.5, aLowerLeft.x());
        assertEquals(2.5, aLowerLeft.y());
        assertEquals(3.5, aUpperRight.x());
        assertEquals(4.5, aUpperRight.y());
        assertEquals(5.5, bLowerLeft.x());
        assertEquals(6.5, bLowerLeft.y());
        assertEquals(7.5, bUpperRight.x());
        assertEquals(8.5, bUpperRight.y());
    }

    @Test
    void testParseInputInvalidCharacter() {
        String[] args = {"1,2;3,four", "five,6;7,8"};

        try {
            parseInput(args);
            fail();
        } catch (InvalidInputException e) {
            assertEquals("Error parsing input. Check that input contains "
                    + "numeric pairs with valid delimiters.\n"
                    + "Example: \"0,0;2.5,2\" \"1.8,1;3,3\"", e.getMessage());
        }
    }

    @Test
    void testParseInputInvalidDelimiter() {
        String[] args = {"1,2|3,4", "5,6|7,8"};

        try {
            parseInput(args);
            fail();
        } catch (InvalidInputException e) {
            assertEquals("Error parsing input. Check that input contains "
                    + "numeric pairs with valid delimiters.\n"
                    + "Example: \"0,0;2.5,2\" \"1.8,1;3,3\"", e.getMessage());
        }
    }
}
