package co.sepulveda.drawing.printing;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlossepulveda
 */
public class OutputPrinter {

    private static final Logger logger = Logger.getLogger(OutputPrinter.class.getName());

    private static final String OUTPUT_FILE = "output.txt";

    private final StringBuilder output;

    public OutputPrinter() {
        output = new StringBuilder("");
    }

    public void print(char[][] canvas) {
        printLine(canvas);
        output.append("\n");
        printCanvas(canvas);
        printLine(canvas);
        output.append("\n");
    }

    private void printCanvas(char[][] canvas) {
        for (char[] row : canvas) {
            output.append("|");
            printRow(row);
            output.append("|\n");
        }
    }

    private void printRow(char[] row) {
        for (char cell : row) {
            char c = normalize(cell);
            output.append(c);
        }
    }

    private char normalize(char c) {
        if (!isEmpty(c)) {
            return c;
        } else {
            return ' ';
        }
    }

    private void printLine(char[][] data) {
        int i = 0;
        int rowSize = data[0].length;
        while (i <= rowSize + 1) {
            output.append('-');
            i++;
        }
    }

    private boolean isEmpty(char c) {
        return c == (char) 0;
    }

    public void save() {
        try {
            String outputStr = output.toString();
            Path path = Paths.get(OUTPUT_FILE);
            Files.write(path, outputStr.getBytes());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception saving file", e);
        }
    }
}
