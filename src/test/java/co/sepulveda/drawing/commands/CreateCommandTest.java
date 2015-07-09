package co.sepulveda.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class CreateCommandTest {

    @Test
    public void shouldParseCreateCommand() {
        String[] data = new String[]{"C", "1", "2"};
        CreateCommand command = CreateCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertEquals(1, command.getWidth());
        Assert.assertEquals(2, command.getHeight());
    }

    @Test
    public void shouldFailIfDataSizeIsWrong() {
        String[] data = new String[]{"C", "1", "2", "3"};
        CreateCommand command = CreateCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"C", "1"};
        command = CreateCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfInvalidKey() {
        String[] data = new String[]{"H", "1", "2"};
        CreateCommand command = CreateCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfIsNotValidSize() {
        String[] data = new String[]{"C", "-1", "2"};
        CreateCommand command = CreateCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"C", "1", "-2"};
        command = CreateCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"C", "0", "0"};
        command = CreateCommand.parse(data);
        Assert.assertNull(command);
    }
}
