import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleSpeedMonitorTest
{

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
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
        System.setIn(originalIn);
    }

    @Test
    void carWithinLimit_thenExit()
    {
        String input = String.join("\n", "Car", "90", "Car", "-1") + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        VehicleSpeedMonitor.main(new String[0]);

        String console = out.toString();
        assertTrue(console.contains("Speed OK"));
        assertTrue(console.contains("Exiting system"));
    }

    @Test
    void carAboveLimit()
    {
        String input = String.join("\n", "Car", "101", "Car", "-1") + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        VehicleSpeedMonitor.main(new String[0]);

        String console = out.toString();
        assertTrue(console.contains("Speeding!"));
    }

    @Test
    void busAtLimit_and_busAboveLimit()
    {
        String input = String.join("\n", "Bus", "80", "Bus", "81", "Car", "-1") + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        VehicleSpeedMonitor.main(new String[0]);

        String console = out.toString();
        assertTrue(console.contains("Speed OK"));
        assertTrue(console.contains("Speeding!"));
    }

    @Test
    void bikeAtLimit_and_unknownType()
    {
        String input = String.join("\n", "Bike", "60", "Train", "50", "Car", "-1") + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        VehicleSpeedMonitor.main(new String[0]);

        String console = out.toString();
        assertTrue(console.contains("Speed OK"));
        assertTrue(console.contains("Unknown vehicle type"));
    }

    @Test
    void exitImmediately_firstSpeedNegative()
    {
        String input = String.join("\n", "Car", "-1") + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        VehicleSpeedMonitor.main(new String[0]);

        String console = out.toString();
        assertTrue(console.contains("Exiting system"));
    }
}
