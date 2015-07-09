package co.sepulveda.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class RectangleCommandTest {

    @Test
    public void shouldParseRectangleCommand() {
        String[] data = new String[]{"R", "16", "1", "20", "3"};
        RectangleCommand command = RectangleCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertEquals(16, command.getX1());
        Assert.assertEquals(1, command.getY1());
        Assert.assertEquals(20, command.getX2());
        Assert.assertEquals(3, command.getY2());
    }

    @Test
    public void shouldFailIfDataSizeIsWrong() {
        String[] data = new String[]{"R", "16", "1", "20", "3", "5"};
        RectangleCommand command = RectangleCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"R", "16", "1", "20"};
        command = RectangleCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfInvalidKey() {
        String[] data = new String[]{"H", "16", "1", "20", "3"};
        RectangleCommand command = RectangleCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfIsNotValidCoors() {
        String[] data = new String[]{"R", "16", "-1", "20", "3"};
        RectangleCommand command = RectangleCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"R", "16", "1", "20", "-3"};
        command = RectangleCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"R", "0", "2", "3", "0"};
        command = RectangleCommand.parse(data);
        Assert.assertNull(command);
    }
}
