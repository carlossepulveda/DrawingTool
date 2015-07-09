package co.sepulveda.drawing.commands;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class CommandsParserTest {

    @Test
    public void shouldParseCreateCommand() {
        String line = "C 1 2";
        CommandsParser parser = new CommandsParser();
        Command command = parser.parse(line);
        Assert.assertNotNull(command);
        Assert.assertEquals(CreateCommand.NAME, command.getName());
    }

    @Test
    public void shouldParseLineCommand() {
        String line = "L 1 2 3 2";
        CommandsParser parser = new CommandsParser();
        Command command = parser.parse(line);
        Assert.assertNotNull(command);
        Assert.assertEquals(LineCommand.NAME, command.getName());
    }

    @Test
    public void shouldParseRectangleCommand() {
        String line = "R 1 2 3 2";
        CommandsParser parser = new CommandsParser();
        Command command = parser.parse(line);
        Assert.assertNotNull(command);
        Assert.assertEquals(RectangleCommand.NAME, command.getName());
    }

    @Test
    public void shouldParseBucketCommand() {
        String line = "B 1 2 o";
        CommandsParser parser = new CommandsParser();
        Command command = parser.parse(line);
        Assert.assertNotNull(command);
        Assert.assertEquals(BucketCommand.NAME, command.getName());
    }

    @Test
    public void shouldReturnNullIfInvalidData() {
        CommandsParser parser = new CommandsParser();

        String line = "H 1 2 3 2";
        Command command = parser.parse(line);
        Assert.assertNull(command);

        line = "C 1";
        command = parser.parse(line);
        Assert.assertNull(command);

        line = "L 1";
        command = parser.parse(line);
        Assert.assertNull(command);

        line = "B 1";
        command = parser.parse(line);
        Assert.assertNull(command);

        line = "R 1";
        command = parser.parse(line);
        Assert.assertNull(command);
    }

    @Test
    public void shouldNormalizeString() {
        CommandsParser parser = new CommandsParser();

        String line = "C      1   2   ";
        Command command = parser.parse(line);
        Assert.assertNotNull(command);
        Assert.assertEquals(CreateCommand.NAME, command.getName());
    }
}
