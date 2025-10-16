package Ch45_ex3;

public class Calculator
{

    public int add(int a, int b)
    {
        System.out.println("Called: add(int, int)");
        return a + b;
    }

    public double add(double a, double b)
    {
        System.out.println("Called: add(double, double)");
        return a + b;
    }

    public double add(int a, double b)
    {
        System.out.println("Called: add(int, double)");
        return a + b;
    }

    public static void main(String[] args)
    {
        Calculator calc = new Calculator();

        int result1 = calc.add(5, 10);
        System.out.println("Result (int, int): " + result1);

        double result2 = calc.add(2.5, 3.7);
        System.out.println("Result (double, double): " + result2);

        double result3 = calc.add(4, 5.5);
        System.out.println("Result (int, double): " + result3);

        double result4 = calc.add(2.3, 5);
        System.out.println("Result (double, int): " + result4);
    }
}