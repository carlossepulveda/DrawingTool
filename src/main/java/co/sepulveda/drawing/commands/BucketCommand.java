package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class BucketCommand extends Command {

    public static final String KEY = "B";

    public static final String NAME = "BUCKET";

    @Override
    public String getName() {
        return NAME;
    }

    public static BucketCommand parse(String[] data) {
        return new BucketCommand();
    }
}
