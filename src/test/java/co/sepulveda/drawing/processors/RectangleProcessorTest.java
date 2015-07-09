package co.sepulveda.drawing.processors;

import co.sepulveda.drawing.commands.RectangleCommand;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class RectangleProcessorTest {

    @Test
    public void shouldDrawRectangle() {
        char[][] canvas = new char[5][8];
        String[] data = new String[] {"R", "3", "2", "6", "4"};
        RectangleCommand command = RectangleCommand.parse(data);
        RectangleProcessor processor = new RectangleProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[5][8];
        expectedCanvas[1][2] = 'x';
        expectedCanvas[1][3] = 'x';
        expectedCanvas[1][4] = 'x';
        expectedCanvas[1][5] = 'x';

        expectedCanvas[3][2] = 'x';
        expectedCanvas[3][3] = 'x';
        expectedCanvas[3][4] = 'x';
        expectedCanvas[3][5] = 'x';

        expectedCanvas[1][2] = 'x';
        expectedCanvas[2][2] = 'x';
        expectedCanvas[3][2] = 'x';

        expectedCanvas[1][5] = 'x';
        expectedCanvas[2][5] = 'x';
        expectedCanvas[3][5] = 'x';

        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }

    @Test
    public void shouldFailIsInvalidRectangle() {
        char[][] canvas = new char[5][8];
        String[] data = new String[] {"R", "5", "2", "4", "4"};
        RectangleCommand command = RectangleCommand.parse(data);
        RectangleProcessor processor = new RectangleProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[5][8];
        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);

        canvas = new char[5][8];
        data = new String[] {"R", "3", "4", "6", "2"};
        command = RectangleCommand.parse(data);
        processor = new RectangleProcessor();
        processor.process(canvas, command);

        expectedCanvas = new char[5][8];
        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }
}
