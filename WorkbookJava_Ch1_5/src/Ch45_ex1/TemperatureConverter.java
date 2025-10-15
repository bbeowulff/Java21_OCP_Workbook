package Ch45_ex1;

public class TemperatureConverter
{

    public static double convert(double fahrenheit)
    {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convert(float celsius)
    {
        return (celsius * 9 / 5) + 32;
    }

}

