package rectangle.analyzer.service;

import rectangle.analyzer.exception.InvalidRectangleException;
import rectangle.analyzer.model.Rectangle;

public final class RectangleValidator {

    private RectangleValidator() {
    }

    public static Rectangle assertValid(final Rectangle r) {
        if (r.lowerLeft().x() > r.upperRight().x()
                || r.lowerLeft().y() > r.upperRight().y()) {
            throw new InvalidRectangleException();
        }
        return r;
    }
}

