package rectangle.analyzer.model;

/**
 * This class represents a rectangle, composed of two points.
 * @param lowerLeft the lower left point
 * @param upperRight the upper right point
 */
public record Rectangle(Point lowerLeft, Point upperRight) {
}
