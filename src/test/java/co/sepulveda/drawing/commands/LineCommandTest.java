package co.sepulveda.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class LineCommandTest {

    @Test
    public void shouldParseLineCommand() {
        String[] data = new String[]{"L", "1", "2", "3", "2"};
        LineCommand command = LineCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertEquals(1, command.getX1());
        Assert.assertEquals(2, command.getY1());
        Assert.assertEquals(3, command.getX2());
        Assert.assertEquals(2, command.getY2());
    }

    @Test
    public void shouldFailIfInvalidDataSize() {
        String[] data = new String[]{"L", "1", "2", "3", "2", "2"};
        LineCommand command = LineCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"L", "1", "2", "3"};
        command = LineCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfInvalidKey() {
        String[] data = new String[]{"H", "1", "2", "3", "2"};
        LineCommand command = LineCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfIsNotValidCoors() {
        String[] data = new String[]{"L", "-1", "2", "-3", "2"};
        LineCommand command = LineCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"L", "1", "-2", "3", "-2"};
        command = LineCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"L", "0", "2", "3", "0"};
        command = LineCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldReturnIsHorizontalOrVertical() {
        String[] data = new String[]{"L", "1", "2", "3", "2"};
        LineCommand command = LineCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertTrue(command.isHorizontalOrVertical());

        data = new String[]{"L", "1", "3", "1", "5"};
        command = LineCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertTrue(command.isHorizontalOrVertical());
    }

    @Test
    public void shouldReturnIsNotHorizontalOrVertical() {
        String[] data = new String[]{"L", "1", "2", "4", "4"};
        LineCommand command = LineCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertFalse(command.isHorizontalOrVertical());
    }
}
