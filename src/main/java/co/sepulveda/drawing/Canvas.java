package co.sepulveda.drawing;

import co.sepulveda.drawing.commands.Command;

/**
 *
 * @author carlossepulveda
 */
public class Canvas {

    private final int width;

    private final int height;

    private final char[][] data;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        data = new char[width][height];
    }

    public void execute(Command command) {
        
    }

    public char[][] getData() {
        return data;
    }
}
