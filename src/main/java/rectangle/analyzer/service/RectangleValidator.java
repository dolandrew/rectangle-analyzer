package rectangle.analyzer.service;

import rectangle.analyzer.exception.InvalidRectangleException;
import rectangle.analyzer.model.Rectangle;

public final class RectangleValidator {

    private RectangleValidator() {
    }

    /**
     * Assert that the given rectangle is valid.
     * @param r a given rectangle
     * @return if valid, return the rectangle, otherwise throw exception
     * @throws InvalidRectangleException
     */
    public static Rectangle assertValid(final Rectangle r) {
        if (r.lowerLeft().x() > r.upperRight().x()
                || r.lowerLeft().y() > r.upperRight().y()) {
            throw new InvalidRectangleException();
        }
        return r;
    }
}

