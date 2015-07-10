package co.sepulveda.drawing;

import co.sepulveda.drawing.printing.OutputPrinter;
import co.sepulveda.drawing.commands.BucketCommand;
import co.sepulveda.drawing.commands.Command;
import co.sepulveda.drawing.commands.CommandsParser;
import co.sepulveda.drawing.commands.CreateCommand;
import co.sepulveda.drawing.commands.LineCommand;
import co.sepulveda.drawing.commands.RectangleCommand;
import co.sepulveda.drawing.processors.BucketProcessor;
import co.sepulveda.drawing.processors.LineProcessor;
import co.sepulveda.drawing.processors.RectangleProcessor;
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
        boolean commandsAreEmpty = isEmpty(commands);
        if (commandsAreEmpty) {
            logger.log(Level.SEVERE, "Commands cannot be empty");
            return;
        }

        String firstCommandLine = commands.get(0);
        CommandsParser commandParser = new CommandsParser();
        Command firstCommand = commandParser.parse(firstCommandLine);
        if (!(firstCommand instanceof CreateCommand)) {
            logger.log(Level.SEVERE, "First command must be CREATE");
            return;
        }

        CreateCommand createCommand = (CreateCommand) firstCommand;
        int width = createCommand.getWidth();
        int height = createCommand.getHeight();
        char[][] canvas = new char[height][width];
        OutputPrinter printer = new OutputPrinter();
        printer.print(canvas);
        logger.log(Level.INFO, "New canvas : width {0},  height {1}", new Object[]{width, height});

        processCommands(canvas, commands, printer);
        printer.save();
    }

    private void processCommands(char[][] canvas, List<String> commands, OutputPrinter printer) {
        CommandsParser commandParser = new CommandsParser();
        for (int i = 1; i < commands.size(); i++) {
            String commandLine = commands.get(i);
            Command command = commandParser.parse(commandLine);
            processCommand(canvas, command, printer);
        }
    }

    private void processCommand(char[][] canvas, Command command, OutputPrinter printer) {
        logger.log(Level.INFO, "Processing command : {0}", command.toString());
        if (command instanceof LineCommand) {
            LineCommand lineCommand = (LineCommand) command;
            LineProcessor lineProcessor = new LineProcessor();
            lineProcessor.process(canvas, lineCommand);
        }

        if (command instanceof RectangleCommand) {
            RectangleCommand rectangleCommand = (RectangleCommand) command;
            RectangleProcessor rectangleProcessor = new RectangleProcessor();
            rectangleProcessor.process(canvas, rectangleCommand);
        }

        if (command instanceof BucketCommand) {
            BucketCommand bucketCommand = (BucketCommand) command;
            BucketProcessor bucketProcessor = new BucketProcessor();
            bucketProcessor.process(canvas, bucketCommand);
        }

        printer.print(canvas);
    }

    private boolean isEmpty(List commands) {
        return commands == null || commands.isEmpty();
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
