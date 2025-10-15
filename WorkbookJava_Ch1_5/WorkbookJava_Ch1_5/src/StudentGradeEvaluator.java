import java.util.Scanner;

public class StudentGradeEvaluator
{
    public static double calculateAverage(int[] scores)
    {
        int sum = 0;
        for (int s : scores) sum += s;
        return (double) sum / scores.length;
    }

    public static String letterGrade(double average)
    {
        return switch ((int) average / 10)
        {
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C";
            case 6     -> "D";
            default    -> "F"; // 0–59
        };
    }

    public static String evaluateStudent(double average, int attendance)
    {
        if (average >= 70 && attendance >= 75) return "PASS";
        else if (average >= 50 && average < 70) return "RE-EXAM";
        else return "FAIL";
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.print("Enter student name (or 'exit' to stop): ");
            Object nameObj = sc.nextLine();

            if (!(nameObj instanceof String name) || name.isBlank())
            {
                System.out.println("Invalid name. Try again.");
                continue;
            }
            if ("exit".equalsIgnoreCase(name.trim()))
            {
                System.out.println("Program terminated.");
                break;
            }

            int[] scores = new int[3];
            System.out.print("Enter 3 test scores: ");
            for (int i = 0; i < scores.length; i++)
            {
                if (!sc.hasNextInt())
                {
                    System.out.print("(Not a number) Enter a valid score: ");
                    sc.next();
                    i--;
                    continue;
                }
                int score = sc.nextInt();
                if (score < 0 || score > 100)
                {
                    System.out.print("(Out of range 0..100) Re-enter score: ");
                    i--;
                    continue;
                }
                scores[i] = score;
            }

            System.out.print("Enter attendance percentage: ");
            int attendance;
            if (!sc.hasNextInt())
            {
                System.out.println("Invalid attendance. Skipping student.");
                sc.nextLine();
                continue;
            } else
            {
                attendance = sc.nextInt();
            }
            sc.nextLine();

            if (attendance < 0 || attendance > 100)
            {
                System.out.println("Attendance must be 0..100");
                continue;
            }

            double average = calculateAverage(scores);
            String grade = letterGrade(average);
            String status = evaluateStudent(average, attendance);
            String attendanceNote = (attendance >= 75) ? "attendance OK" : "attendance low";

            System.out.printf("Average: %.1f%n", average);
            System.out.println("Grade: " + grade + " → " + status);
            System.out.println("(" + attendanceNote + ")");
            System.out.println();
        }

        sc.close();
    }
}
