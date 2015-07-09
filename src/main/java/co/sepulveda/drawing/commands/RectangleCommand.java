package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class RectangleCommand extends Command {

    public static final String KEY = "R";

    public static final String NAME = "RECTANGLE";

    @Override
    public String getName() {
        return NAME;
    }

    public static RectangleCommand parse(String[] data) {
        return new RectangleCommand();
    }
}
