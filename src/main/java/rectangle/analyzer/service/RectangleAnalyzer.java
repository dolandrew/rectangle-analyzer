package rectangle.analyzer.service;

import rectangle.analyzer.model.Rectangle;

import static java.lang.String.format;

public final class RectangleAnalyzer {

    private RectangleAnalyzer() {
    }

    /**
     * Analyze two rectangles and determine their relationship.
     * @param a rectangle to compare
     * @param b rectangle to compare
     * @return string describing their relationship for output
     */
    public static String analyze(final Rectangle a, final Rectangle b) {
        String relationship = "";
        if (contains(a, b)) {
            relationship = "contains";
        } else if (contains(b, a)) {
            relationship = "is contained by";
        } else if (intersects(a, b)) {
            relationship = "intersects";
        } else if (isAdjacent(a, b)) {
            relationship = "is adjacent to";
        } else {
            relationship = "has no relationship to";
        }
        return describe(relationship);
    }

    /**
     * Test if rectangle a contains rectangle b
     * @param a rectangle a
     * @param b rectangle b
     * @return true if contains, false otherwise
     */
    static boolean contains(final Rectangle a, final Rectangle b) {
        return a.upperRight().x() >= b.upperRight().x()
                && a.upperRight().y() >= b.upperRight().y()
                && a.lowerLeft().x() <= b.lowerLeft().x()
                && a.lowerLeft().y() <= b.lowerLeft().y();
    }

    /**
     * Test if rectangle a intersects rectangle b
     * @param a rectangle a
     * @param b rectangle b
     * @return true if intersects, false otherwise
     */
    static boolean intersects(final Rectangle a, final Rectangle b) {
        return b.lowerLeft().x() < a.upperRight().x()
                && b.lowerLeft().y() < a.upperRight().y()
                && a.lowerLeft().x() < b.upperRight().x()
                && a.lowerLeft().y() < b.upperRight().y();
    }

    /**
     * Test if rectangle a is adjacent to rectangle b
     * @param a rectangle a
     * @param b rectangle b
     * @return true if adjacent, false otherwise
     */
    static boolean isAdjacent(final Rectangle a, final Rectangle b) {
        return b.lowerLeft().y() == a.upperRight().x()
                || b.upperRight().y() == a.lowerLeft().x()
                || a.lowerLeft().y() == b.upperRight().x()
                || a.upperRight().y() == b.lowerLeft().x();
    }

    /**
     * Builds a fully human-readable string describing a relationship
     * between two rectangles
     * @param relationship the relationship, i.e. "contains"
     * @return string describing relationship
     */
    private static String describe(final String relationship) {
        return format("Rectangle A %s Rectangle B.", relationship);
    }
}

