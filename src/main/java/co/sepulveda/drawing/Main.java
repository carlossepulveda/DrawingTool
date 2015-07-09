package co.sepulveda.drawing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossepulveda
 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String [] args) throws IOException {
        logger.log(Level.INFO, "Initializing ...");

        String inputFilePath = getInputFilePath(args);
        Painter painter = new Painter(inputFilePath);
        painter.paint();
    }

    public static String getInputFilePath(String [] args) {
        if (args.length > 0) {
            return args[0];
        }

        return null;
    }
}
