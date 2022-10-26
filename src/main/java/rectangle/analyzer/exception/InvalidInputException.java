package rectangle.analyzer.exception;

public final class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("Error parsing input. Check that input contains numeric pairs "
                + "with valid delimiters.\n"
                + "Example: \"0,0;2.5,2\" \"1.8,1;3,3\"");
    }
}
