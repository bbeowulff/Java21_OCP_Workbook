import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("StudentGradeEvaluator – unit & integration tests")
class StudentGradeEvaluatorTest
{

    /* ===================== UNIT TESTS ===================== */

    @Nested
    @Tag("unit")
    @DisplayName("Unit: pure methods")
    class UnitTests
    {

        @Order(1)
        @ParameterizedTest(name = "avg={0} -> grade={1}")
        @CsvSource({
                "100, A", "95.5, A",
                "89.9, B", "80, B",
                "79.9, C", "70, C",
                "69.9, D", "60, D",
                "59.9, F", "0, F"
        })
        void letterGrade_mapping(double average, String expected)
        {
            assertEquals(expected, StudentGradeEvaluator.letterGrade(average));
        }

        @Order(2)
        @ParameterizedTest(name = "scores={0}|{1}|{2} -> avg={3}")
        @CsvSource({
                "80,85,90,85.0",
                "0,0,0,0.0",
                "100,100,100,100.0",
                "60,70,80,70.0"
        })
        void calculateAverage_values(int s1, int s2, int s3, double expected)
        {
            double avg = StudentGradeEvaluator.calculateAverage(new int[]{s1, s2, s3});
            assertEquals(expected, avg, 1e-9);
        }

        @Order(3)
        @ParameterizedTest(name = "avg={0}, att={1} -> {2}")
        @CsvSource({
                "85, 92, PASS",
                "70, 75, PASS",
                "57.7, 65, RE-EXAM",
                "60, 10, RE-EXAM",
                "72, 70, FAIL",
                "49.9, 90, FAIL"
        })
        void evaluateStudent_rules(double avg, int att, String expected)
        {
            assertEquals(expected, StudentGradeEvaluator.evaluateStudent(avg, att));
        }
    }

    /* ================= INTEGRATION TESTS ================= */

    @Nested
    @Tag("integration")
    @DisplayName("Integration: console I/O through main")
    class IntegrationTests
    {

        private final PrintStream originalOut = System.out;
        private final InputStream originalIn = System.in;
        private ByteArrayOutputStream out;

        @BeforeEach
        void redirect()
        {
            out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
        }

        @AfterEach
        void restore()
        {
            System.setOut(originalOut);
            System.setIn(originalIn);
        }

        private String runMainWithInput(String... lines)
        {
            String sep = System.lineSeparator();
            String input = String.join(sep, lines) + sep;
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            StudentGradeEvaluator.main(new String[0]);
            return out.toString();
        }

        @Order(4)
        @Test
        @Timeout(2)
        @DisplayName("Happy path: valid student then exit")
        void main_validStudent_thenExit()
        {
            String console = runMainWithInput(
                    "Alice",
                    "80 85 90",
                    "92",
                    "exit"
            );
            assertAll(
                    () -> assertTrue(console.contains("Average: 85.0")),
                    () -> assertTrue(console.contains("Grade: B → PASS")),
                    () -> assertTrue(console.toLowerCase().contains("program terminated"))
            );
        }

        @Order(5)
        @Test
        @Timeout(2)
        @DisplayName("Invalid tokens are skipped; next student processed")
        void main_invalidTokens_thenValidStudent()
        {
            String console = runMainWithInput(
                    "Bob",
                    "55 xx 60",
                    "58",
                    "two",
                    "Charlie",
                    "70 70 70",
                    "75",
                    "exit"
            );
            assertAll(
                    () -> assertTrue(console.contains("Average: 70.0")),
                    () -> assertTrue(console.contains("Grade: C → PASS"))
            );
        }

        @Order(6)
        @Test
        @Timeout(2)
        @DisplayName("Attendance out of range triggers skip")
        void main_attendanceOutOfRange_skips()
        {
            String console = runMainWithInput(
                    "Dana",
                    "60 60 60",
                    "200",
                    "exit"
            );
            assertTrue(console.contains("Attendance must be 0..100"));
        }

        @Order(7)
        @Test
        @Timeout(2)
        @DisplayName("Blank name handled via continue, then RE-EXAM (F)")
        void main_emptyName_thenProceed()
        {
            String console = runMainWithInput(
                    "   ",
                    "Eli",
                    "50 60 55",
                    "60",
                    "exit"
            );
            assertAll(
                    () -> assertTrue(console.contains("Invalid name. Try again.")),
                    () -> assertTrue(console.contains("Grade: F → RE-EXAM"))
            );
        }
    }
}
