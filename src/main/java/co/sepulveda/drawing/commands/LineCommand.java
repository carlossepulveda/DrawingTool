package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class LineCommand extends Command {

    public static final String KEY = "L";

    public static final String NAME = "LINE";

    @Override
    public String getName() {
        return NAME;
    }

    public static LineCommand parse(String[] data) {
        return new LineCommand();
    }
}
