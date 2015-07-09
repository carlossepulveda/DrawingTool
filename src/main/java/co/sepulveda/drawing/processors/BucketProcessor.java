package co.sepulveda.drawing.processors;

import co.sepulveda.drawing.commands.BucketCommand;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossepulveda
 */
public class BucketProcessor {

    private static final Logger logger = Logger.getLogger(BucketProcessor.class.getName());

    public void process(char[][] canvas, BucketCommand command) {
        int x = command.getX();
        int y = command.getY();
        if (isDataGreaterCanvas(x, y, canvas)) {
            logger.log(Level.SEVERE, "Invalid coors");
            return;
        }

        processBucket(canvas, command);
    }

    private void processBucket(char[][] canvas, BucketCommand command) {
        int x = command.getX();
        int y = command.getY();
        processCoor(x, y, canvas, command.getColor());
    }

    private void processCoor(int x, int y, char[][] canvas, char color) {
        boolean isOut = isDataGreaterCanvas(x, y, canvas);
        if (isOut) {
            return;
        }

        char content = canvas[y - 1][x - 1];
        if (!isEmpty(content)) {
            return;
        }

        canvas[y - 1][x - 1] = color;
        processNeighborLeft(x, y, canvas, color);
        processNeighborRight(x, y, canvas, color);
        processNeighborUp(x, y, canvas, color);
        processNeighborDown(x, y, canvas, color);
    }

    private void processNeighborLeft(int x, int y, char[][] canvas, char color) {
        int xL = x - 1;
        processCoor(xL, y, canvas, color);
    }

    private void processNeighborRight(int x, int y, char[][] canvas, char color) {
        int xR = x + 1;
        processCoor(xR, y, canvas, color);
    }

    private void processNeighborUp(int x, int y, char[][] canvas, char color) {
        int yU = y - 1;
        processCoor(x, yU, canvas, color);
    }

    private void processNeighborDown(int x, int y, char[][] canvas, char color) {
        int yD = y + 1;
        processCoor(x, yD, canvas, color);
    }

    private boolean isDataGreaterCanvas(int x, int y, char[][] canvas) {
        return x > canvas[0].length || y > canvas.length
                || x < 1 || y < 1;
    }

    private boolean isEmpty(char content) {
        return content == (char) 0;
    }
}
