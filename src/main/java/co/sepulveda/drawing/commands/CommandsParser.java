package co.sepulveda.drawing.commands;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author carlossepulveda
 */
public class CommandsParser {

    private static final List VALID_COMMANDS = Arrays.asList(CreateCommand.KEY, LineCommand.KEY, RectangleCommand.KEY, BucketCommand.KEY);

    public Command parse(String line) {
        String[] data = getData(line);
        if (!isValid(data)) {
            return null;
        }

        String key = data[0];
        Command command = null;
        if (CreateCommand.KEY.equals(key)) {
            command = CreateCommand.parse(data);
        }

        if (LineCommand.KEY.equals(key)) {
            command = LineCommand.parse(data);
        }

        if (RectangleCommand.KEY.equals(key)) {
            command = RectangleCommand.parse(data);
        }

        if (BucketCommand.KEY.equals(key)) {
            command = BucketCommand.parse(data);
        }

        return command;
    }

    private String[] getData(String line) {
        line = line.replaceAll("\\s+"," ");
        String[] data = line.split(" ");

        return data;
    }

    private boolean isValid(String[] data) {
        return data.length >= 3 && VALID_COMMANDS.contains(data[0]);
    }
}
