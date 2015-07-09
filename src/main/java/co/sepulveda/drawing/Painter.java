package co.sepulveda.drawing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossepulveda
 */
public class Painter {

    private static final String DEFAULT_INPUT_FILE = "input.txt";

    private final String pathToInput;

    private static final Logger logger = Logger.getLogger(Painter.class.getName());

    public Painter(String pathToInput) {
        if (pathToInput == null || pathToInput.isEmpty()) {
            this.pathToInput = DEFAULT_INPUT_FILE;
        } else {
            this.pathToInput = pathToInput;
        }
    }

    public void paint() {
        List<String> commands = readCommands();
        logger.log(Level.INFO, commands.toString());
    }

    private List readCommands() {
        Path path = Paths.get(pathToInput);
        List commands = null;
        try {
            commands = Files.readAllLines(path);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception reading file", ex);
        }
        return commands;
    }
}
