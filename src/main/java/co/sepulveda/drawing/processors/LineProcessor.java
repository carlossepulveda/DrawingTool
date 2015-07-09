/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        for (int i= x1 - 1; i + 1 <= x2; i++) {
            canvas[y - 1][i] = CHAR;
        }
    }

    private void processVerticalLine(char[][] canvas, LineCommand command) {
        int y1 = command.getY1();
        int y2 = command.getY2();
        if (command.getY1() > command.getY2()) {
            y1 = command.getY2();
            y2 = command.getY1();
        }

        int x = command.getX1();
        for (int i= y1 - 1; i + 1 <= y2; i++) {
            canvas[i][x - 1] = CHAR;
        }
    }
}
