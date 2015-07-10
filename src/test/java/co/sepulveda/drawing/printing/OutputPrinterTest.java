package co.sepulveda.drawing.printing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author carlossepulveda
 */
public class OutputPrinterTest {

    private static final String OUTPUT_FILE = "output.txt";

    @Test
    public void shouldPrintCanvasOutputFile() {
        char[][] canvas = new char[4][4];
        canvas[1][1] = 'x';
        canvas[2][2] = 'y';
        canvas[3][3] = 'o';
        OutputPrinter printer = new OutputPrinter();
        printer.print(canvas);
        printer.save();

        String outputString = readOutputFile();
        String expectedString = "------\n" +
                                "|    |\n" +
                                "| x  |\n" +
                                "|  y |\n" +
                                "|   o|\n" +
                                "------\n";

        File outputFile = new File(OUTPUT_FILE);
        outputFile.deleteOnExit();

        Assert.assertTrue(outputFile.exists());
        Assert.assertEquals(outputString, expectedString);
    }

    private String readOutputFile() {
        Path path = Paths.get(OUTPUT_FILE);
        try {
            List<String> lines = Files.readAllLines(path);
            return getText(lines);
        } catch (IOException ex) {
            return null;
        }
    }

    private String getText(List<String> lines) {
        String text = "";
        for (String line : lines) {
            text += line + "\n";
        }
        return text;
    }
}
