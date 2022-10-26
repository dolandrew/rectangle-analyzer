package rectangle.analyzer.exception;

public final class InvalidRectangleException extends IllegalArgumentException {
    public InvalidRectangleException() {
        super("Invalid rectangle. Check the input and ensure valid lower left "
                + "and upper right points.\n"
                + "Example: \"0,0;2.5,2\" \"1.8,1;3,3\"");
    }
}
