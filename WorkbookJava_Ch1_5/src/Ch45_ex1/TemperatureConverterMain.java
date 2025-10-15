package Ch45_ex1;

import java.util.Scanner;
import static Ch45_ex1.TemperatureConverter.convert;

public class TemperatureConverterMain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double value = sc.nextDouble();

        System.out.print("Enter unit (C/F): ");
        String unit = sc.next().trim().toUpperCase();

        double result;

        if (unit.equals("C"))
        {
            result = convert((float) value);
            System.out.printf("%.2f°C = %.2f°F%n", value, result);
        } else if (unit.equals("F"))
        {
            result = convert(value);
            System.out.printf("%.2f°F = %.2f°C%n", value, result);
        } else
        {
            System.out.println("Invalid unit. Please enter 'C' or 'F'.");
        }

        sc.close();
    }
}
