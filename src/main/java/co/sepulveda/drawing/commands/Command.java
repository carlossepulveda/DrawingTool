package co.sepulveda.drawing.commands;

/**
 *
 * @author carlossepulveda
 */
public abstract class Command {

    public abstract String getName();

    public abstract String getKey();

    protected static int getInt(String number) {
        try {
            
            return Integer.parseInt(number);
        } catch(Exception e) {
            return -1;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
