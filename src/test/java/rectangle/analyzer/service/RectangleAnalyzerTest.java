package rectangle.analyzer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rectangle.analyzer.model.Point;
import rectangle.analyzer.model.Rectangle;

class RectangleAnalyzerTest {

    @Test
    void testContainsBContainsA() {
        Rectangle a = new Rectangle(new Point(0, 0), new Point(2, 2));
        Rectangle b = new Rectangle(new Point(0, 0), new Point(3, 3));

        Assertions.assertTrue(RectangleAnalyzer.contains(b, a));
    }

    @Test
    void testContainsADoesNotContainB() {
        Rectangle a = new Rectangle(new Point(0, 0), new Point(2, 2));
        Rectangle b = new Rectangle(new Point(0, 0), new Point(3, 3));

        Assertions.assertFalse(RectangleAnalyzer.contains(a, b));
    }

    @Test
    void testIntersectsAWithB() {
        Rectangle a = new Rectangle(new Point(0, 0), new Point(2, 2));
        Rectangle b = new Rectangle(new Point(1, 1), new Point(4, 4));

        Assertions.assertTrue(RectangleAnalyzer.intersects(b, a));
    }

    @Test
    void testIntersectsBWithA() {
        Rectangle a = new Rectangle(new Point(0, 0), new Point(2, 2));
        Rectangle b = new Rectangle(new Point(1, 1), new Point(4, 4));

        Assertions.assertTrue(RectangleAnalyzer.intersects(a, b));
    }

    @Test
    void testIsAdjacent() {
        Rectangle a = new Rectangle(new Point(0, 0), new Point(2, 2));
        Rectangle b = new Rectangle(new Point(0.5, -2), new Point(1.5, 0));

        Assertions.assertTrue(RectangleAnalyzer.isAdjacent(b, a));
    }

    @Test
    void testNoRelationship() {
        Rectangle a = new Rectangle(new Point(0, 0), new Point(2, 2));
        Rectangle b = new Rectangle(new Point(3, 3), new Point(5, 5));

        Assertions.assertFalse(RectangleAnalyzer.contains(b, a));
        Assertions.assertFalse(RectangleAnalyzer.intersects(b, a));
        Assertions.assertFalse(RectangleAnalyzer.isAdjacent(b, a));
    }
}
