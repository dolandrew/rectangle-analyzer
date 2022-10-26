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
     * @return
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

    static boolean contains(final Rectangle a, final Rectangle b) {
        return a.upperRight().x() >= b.upperRight().x()
                && a.upperRight().y() >= b.upperRight().y()
                && a.lowerLeft().x() <= b.lowerLeft().x()
                && a.lowerLeft().y() <= b.lowerLeft().y();
    }

    static boolean intersects(final Rectangle a, final Rectangle b) {
        return b.lowerLeft().x() < a.upperRight().x()
                && b.lowerLeft().y() < a.upperRight().y()
                && a.lowerLeft().x() < b.upperRight().x()
                && a.lowerLeft().y() < b.upperRight().y();
    }

    static boolean isAdjacent(final Rectangle a, final Rectangle b) {
        return b.lowerLeft().y() == a.upperRight().x()
                || b.upperRight().y() == a.lowerLeft().x()
                || a.lowerLeft().y() == b.upperRight().x()
                || a.upperRight().y() == b.lowerLeft().x();
    }

    private static String describe(final String relationship) {
        return format("Rectangle A %s Rectangle B.", relationship);
    }
}

