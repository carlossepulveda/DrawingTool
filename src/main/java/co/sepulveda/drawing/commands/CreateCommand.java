package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class CreateCommand extends Command {

    public static final String KEY = "C";

    public static final String NAME = "CREATE";

    private static final int DATA_SIZE = 3;

    private final int width;

    private final int height;

    public CreateCommand(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static CreateCommand parse(String[] data) {
        if (!data[0].equals(KEY)) {
            return null;
        }

        if (data.length != DATA_SIZE) {
            return null;
        }

        int width = readWidth(data);
        if (width < 1) {
            return null;
        }

        int height = readHeight(data);
        if (height < 1) {
            return null;
        }

        return new CreateCommand(width, height);
    }

    private static int readWidth(String[] data) {
        String width = data[1];
        return getInt(width);
    }

    private static int readHeight(String[] data) {
        String width = data[2];
        return getInt(width);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getKey() {
        return KEY;
    }
}
