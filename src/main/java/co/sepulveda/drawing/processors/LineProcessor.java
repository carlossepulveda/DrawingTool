package co.sepulveda.drawing.processors;

import co.sepulveda.drawing.commands.LineCommand;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossepulveda
 */
public class LineProcessor {

    private static final Logger logger = Logger.getLogger(LineProcessor.class.getName());

    private static final char CHAR = 'x';

    public void process(char[][] canvas, LineCommand command) {
        if (!command.isHorizontalOrVertical()) {
            logger.log(Level.SEVERE, "Currently only horizontal or vertical lines are supported");
            return;
        }

        if (command.isHorizontal()) {
            processHorizontalLine(canvas, command);
        } else {
            processVerticalLine(canvas, command);
        }
    }

    private void processHorizontalLine(char[][] canvas, LineCommand command) {
        int x1 = command.getX1();
        int x2 = command.getX2();
        if (command.getX1() > command.getX2()) {
            x1 = command.getX2();
            x2 = command.getX1();
        }

        int y = command.getY1();
        if (isDataGreaterCanvas(x2, y, canvas)) {
            return;
        }

        for (int i= x1 - 1; i + 1 <= x2; i++) {
            canvas[y - 1][i] = CHAR;
        }
    }

    private boolean isDataGreaterCanvas(int x, int y, char[][] canvas) {
        return x > canvas[0].length || y > canvas.length;
    }

    private void processVerticalLine(char[][] canvas, LineCommand command) {
        int y1 = command.getY1();
        int y2 = command.getY2();
        if (command.getY1() > command.getY2()) {
            y1 = command.getY2();
            y2 = command.getY1();
        }

        int x = command.getX1();
        if (isDataGreaterCanvas(x, y2, canvas)) {
            return;
        }

        for (int i= y1 - 1; i + 1 <= y2; i++) {
            canvas[i][x - 1] = CHAR;
        }
    }
}
