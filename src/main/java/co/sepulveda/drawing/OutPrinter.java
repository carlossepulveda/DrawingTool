package co.sepulveda.drawing;

/**
 *
 * @author carlossepulveda
 */
public class OutPrinter {

    public void print(char[][] data) {
        for (char[] row : data) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void close() {
        
    }
}
