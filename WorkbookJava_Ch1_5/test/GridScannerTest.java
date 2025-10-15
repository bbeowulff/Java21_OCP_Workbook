import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class GridScannerTest
{

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp()
    {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(originalOut);
    }

    @Test
    void testDigitFound()
    {
        char[][] grid = {
                {'.', '.', '#', '.'},
                {'a', '#', 'b', '2'},
                {'.', '.', '.', '.'}
        };
        GridScanner.scanGrid(grid);
        String output = out.toString().trim();
        assertTrue(output.contains("found digit '2' at (row=1, col=3)"));
    }

    @Test
    void testNoDigitFound()
    {
        char[][] grid = {
                {'.', '.', '#', '.'},
                {'a', '#', 'b', 'c'},
                {'.', '.', '.', '.'}
        };
        GridScanner.scanGrid(grid);
        String output = out.toString().trim();
        assertEquals("none", output);
    }

    @Test
    void testIgnoreWalls()
    {
        char[][] grid = {
                {'#', '#', '#', '5'},
                {'#', '#', '#', '#'}
        };
        GridScanner.scanGrid(grid);
        String output = out.toString().trim();
        assertTrue(output.contains("found digit '5' at (row=0, col=3)"));
    }

    @Test
    void testDigitAtStart()
    {
        char[][] grid = {
                {'9', '.', '.', '.'},
                {'.', '.', '.', '.'}
        };
        GridScanner.scanGrid(grid);
        String output = out.toString().trim();
        assertTrue(output.contains("found digit '9' at (row=0, col=0)"));
    }
}
