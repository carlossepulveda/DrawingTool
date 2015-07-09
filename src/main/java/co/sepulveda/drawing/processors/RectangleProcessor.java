package co.sepulveda.drawing.processors;

import co.sepulveda.drawing.commands.RectangleCommand;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossepulveda
 */
public class RectangleProcessor {

    private static final Logger logger = Logger.getLogger(RectangleProcessor.class.getName());

    private static final char CHAR = 'x';

    public void process(char[][] canvas, RectangleCommand command) {
        if (!command.isValidRectangle()) {
            logger.log(Level.SEVERE, "Invalid rectangle");
            return;
        }

        processRectangle(canvas, command);
    }

    private void processRectangle(char[][] canvas, RectangleCommand command) {
        int x1 = command.getX1();
        int x2 = command.getX2();
        int y1 = command.getY1();
        int y2 = command.getY2();
        for (int i = x1 - 1; i + 1 <= x2; i++) {
            canvas[y1 - 1][i] = CHAR;
            canvas[y2 - 1][i] = CHAR;
        }

        for (int i = y1 - 1; i + 1 <= y2; i++) {
            canvas[i][x1 -1] = CHAR;
            canvas[i][x2 - 1] = CHAR;
        }
    }
}
