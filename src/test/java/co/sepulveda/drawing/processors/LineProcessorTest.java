package co.sepulveda.drawing.processors;

import co.sepulveda.drawing.commands.LineCommand;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class LineProcessorTest {

    @Test
    public void shouldDrawHorizontalLine() {
        char[][] canvas = new char[4][7];
        String[] data = new String[] {"L","1", "2", "6", "2"};
        LineCommand command = LineCommand.parse(data);
        LineProcessor processor = new LineProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[4][7];
        expectedCanvas[1][0] = 'x';
        expectedCanvas[1][1] = 'x';
        expectedCanvas[1][2] = 'x';
        expectedCanvas[1][3] = 'x';
        expectedCanvas[1][4] = 'x';
        expectedCanvas[1][5] = 'x';

        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }

    @Test
    public void shouldDrawVerticalLine() {
        char[][] canvas = new char[4][7];
        String[] data = new String[] {"L", "6", "3", "6", "4"};
        LineCommand command = LineCommand.parse(data);
        LineProcessor processor = new LineProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[4][7];
        expectedCanvas[2][5] = 'x';
        expectedCanvas[3][5] = 'x';

        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }

    @Test
    public void shouldFailIsXDataOverflow() {
        char[][] canvas = new char[4][7];
        String[] data = new String[] {"L","1", "2", "8", "2"};
        LineCommand command = LineCommand.parse(data);
        LineProcessor processor = new LineProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[4][7];
        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }

    @Test
    public void shouldFailIsYDataOverflow() {
        char[][] canvas = new char[4][7];
        String[] data = new String[] {"L", "6", "3", "6", "5"};
        LineCommand command = LineCommand.parse(data);
        LineProcessor processor = new LineProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[4][7];
        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }
}
