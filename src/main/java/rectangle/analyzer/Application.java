package rectangle.analyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rectangle.analyzer.model.Rectangle;

import java.util.List;

import static rectangle.analyzer.service.InputParser.parseInput;
import static rectangle.analyzer.service.RectangleAnalyzer.analyze;
import static rectangle.analyzer.service.RectangleValidator.assertValid;

public class Application {

    private static final Logger LOG = LogManager.getLogger(Application.class);

    public static void main(final String[] args) {
        try {
            List<Rectangle> rectangles = parseInput(args);

            Rectangle a = assertValid(rectangles.get(0));
            Rectangle b = assertValid(rectangles.get(1));

            String relationship = analyze(a, b);
            LOG.info(relationship);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
