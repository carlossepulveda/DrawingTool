package co.sepulveda.drawing.processors;

import co.sepulveda.drawing.commands.BucketCommand;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class BucketProcessorTest {

    @Test
    public void shouldFillOutEmptyCanvas() {
        char[][] canvas = new char[2][2];
        String[] data = new String[]{"B", "1", "1", "o"};
        BucketCommand command = BucketCommand.parse(data);
        BucketProcessor processor = new BucketProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[2][2];
        expectedCanvas[0][0] = 'o';
        expectedCanvas[0][1] = 'o';
        expectedCanvas[1][0] = 'o';
        expectedCanvas[1][1] = 'o';
        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }

    @Test
    public void shouldNotFillOutInvalidCoor() {
        char[][] canvas = new char[2][2];
        String[] data = new String[]{"B", "3", "2", "o"};
        BucketCommand command = BucketCommand.parse(data);
        BucketProcessor processor = new BucketProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[2][2];
        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }

    @Test
    public void shouldFillOutOnlyNeighbors() {
        char[][] canvas = new char[4][4];
        canvas[1][0] = 'x';
        canvas[2][0] = 'x';
        canvas[3][1] = 'x';
        canvas[3][2] = 'x';
        canvas[2][2] = 'x';
        canvas[2][3] = 'x';

        String[] data = new String[]{"B", "1", "1", "o"};
        BucketCommand command = BucketCommand.parse(data);
        BucketProcessor processor = new BucketProcessor();
        processor.process(canvas, command);

        char[][] expectedCanvas = new char[4][4];
        expectedCanvas[1][0] = 'x';
        expectedCanvas[2][0] = 'x';
        expectedCanvas[3][1] = 'x';
        expectedCanvas[3][2] = 'x';
        expectedCanvas[2][2] = 'x';
        expectedCanvas[2][3] = 'x';

        expectedCanvas[0][0] = 'o';
        expectedCanvas[0][1] = 'o';
        expectedCanvas[0][2] = 'o';
        expectedCanvas[0][3] = 'o';
        expectedCanvas[1][1] = 'o';
        expectedCanvas[1][2] = 'o';
        expectedCanvas[1][3] = 'o';
        expectedCanvas[2][1] = 'o';

        org.junit.Assert.assertArrayEquals(canvas, expectedCanvas);
    }
}
