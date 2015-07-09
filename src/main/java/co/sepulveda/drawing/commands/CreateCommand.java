package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class CreateCommand extends Command {

    public static final String KEY = "C";

    public static final String NAME = "CREATE";

    @Override
    public String getName() {
        return NAME;
    }

    public static CreateCommand parse(String[] data) {
        return new CreateCommand();
    }
}
