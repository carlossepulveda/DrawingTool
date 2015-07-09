package co.sepulveda.drawing.commands;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class BucketCommandTest {

    @Test
    public void shouldParseBucketCommand() {
        String[] data = new String[]{"B", "3", "4", "X"};
        BucketCommand command = BucketCommand.parse(data);
        Assert.assertNotNull(command);
        Assert.assertEquals(3, command.getX());
        Assert.assertEquals(4, command.getY());
        Assert.assertEquals('X', command.getColor());
    }

    @Test
    public void shouldFailIfInvalidDataSize() {
        String[] data = new String[]{"B", "3", "4", "X", "X"};
        BucketCommand command = BucketCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"B", "3", "4"};
        command = BucketCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfInvalidKey() {
        String[] data = new String[]{"H", "3", "4", "X"};
        BucketCommand command = BucketCommand.parse(data);
        Assert.assertNull(command);
    }

    @Test
    public void shouldFailIfIsNotValidCoors() {
        String[] data = new String[]{"B", "-3", "4", "X"};
        BucketCommand command = BucketCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"B", "3", "-4", "X"};
        command = BucketCommand.parse(data);
        Assert.assertNull(command);

        data = new String[]{"B", "0", "0", "X"};
        command = BucketCommand.parse(data);
        Assert.assertNull(command);
    }
}
