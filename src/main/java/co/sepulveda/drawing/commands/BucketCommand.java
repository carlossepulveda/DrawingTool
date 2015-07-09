package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class BucketCommand extends Command {

    public static final String KEY = "B";

    public static final String NAME = "BUCKET";

    public static final int DATA_SIZE = 4;

    private final int x;

    private final int y;

    private final char color;

    public BucketCommand(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColor() {
        return color;
    }

    public static BucketCommand parse(String[] data) {
        if (!data[0].equals(KEY)) {
            return null;
        }

        if (data.length != DATA_SIZE) {
            return null;
        }

        char color = readColor(data);
        int x = readX(data);
        if (x < 1) {
            return null;
        }

        int y = readY(data);
        if (y < 1) {
            return null;
        }

        return new BucketCommand(x, y, color);
    }

    private static int readX(String[] data) {
        String width = data[1];
        return getInt(width);
    }

    private static int readY(String[] data) {
        String width = data[2];
        return getInt(width);
    }

    private static char readColor(String[] data) {
        return data[3].charAt(0);
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
