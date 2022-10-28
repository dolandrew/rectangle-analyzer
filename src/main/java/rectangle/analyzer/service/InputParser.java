package rectangle.analyzer.service;

import rectangle.analyzer.exception.InvalidInputException;
import rectangle.analyzer.model.Point;
import rectangle.analyzer.model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to parse input from program arguments.
 */
public final class InputParser {

    private static final String PAIR_DELIMITER = ";";
    private static final String POINT_DELIMITER = ",";

    private InputParser() {
    }

    /**
     * Parse input from program arguments.
     * @param args program arguments
     * @return list of (2) rectangles
     */
    public static List<Rectangle> parseInput(final String[] args) {
        assertValidPair(args);

        List<Point[]> points = new ArrayList<>();
        points.add(parsePair(args[0]));
        points.add(parsePair(args[1]));

        Rectangle a = new Rectangle(points.get(0)[0], points.get(0)[1]);
        Rectangle b = new Rectangle(points.get(1)[0], points.get(1)[1]);
        return List.of(a, b);
    }

    /**
     * Parse a pair of points
     * @param pair string representation of pair of points
     * @return Point[] array of Points
     */
    private static Point[] parsePair(final String pair) {
        String[] pointsString = pair.split(PAIR_DELIMITER);
        assertValidPair(pointsString);

        Point[] points = new Point[2];
        points[0] = parsePoint(pointsString[0]);
        points[1] = parsePoint(pointsString[1]);

        return points;
    }

    /**
     * Parse a point into a pair of x, y
     * @param point string representation of point
     * @return parsed Point
     */
    private static Point parsePoint(final String point) {
        String[] pointString = point.split(POINT_DELIMITER);
        assertValidPair(pointString);

        try {
            return new Point(Double.parseDouble(pointString[0]),
                    Double.parseDouble(pointString[1]));
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }

    /**
     * Assert given input is a pair (length 2)
     * @param pair the pair to assert
     * @throws InvalidInputException
     */
    private static void assertValidPair(final String[] pair) {
        if (pair != null && pair.length != 2) {
            throw new InvalidInputException();
        }
    }
}
