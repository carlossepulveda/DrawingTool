package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public class RectangleCommand extends Command {

    public static final String KEY = "R";

    public static final String NAME = "RECTANGLE";

    private static final int DATA_SIZE = 5;

    private final int x1;

    private final int x2;

    private final int y1;

    private final int y2;

    public RectangleCommand(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public static RectangleCommand parse(String[] data) {
        if (!data[0].equals(KEY)) {
            return null;
        }

        if (data.length != DATA_SIZE) {
            return null;
        }

        int x1 = readX1(data);
        if (x1 < 1) {
            return null;
        }

        int x2 = readX2(data);
        if (x2 < 1) {
            return null;
        }

        int y1 = readY1(data);
        if (y1 < 1) {
            return null;
        }

        int y2 = readY2(data);
        if (y2 < 1) {
            return null;
        }

        return new RectangleCommand(x1, y1, x2, y2);
    }

    private static int readX1(String[] data) {
        String width = data[1];
        return getInt(width);
    }

    private static int readY1(String[] data) {
        String width = data[2];
        return getInt(width);
    }

    private static int readX2(String[] data) {
        String width = data[3];
        return getInt(width);
    }

    private static int readY2(String[] data) {
        String width = data[4];
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
