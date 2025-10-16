package Ch45_ex6;

import java.util.*;

abstract class Shape
{
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape
{
    double radius;

    Circle(double radius)
    {
        this.radius = radius;
    }

    @Override
    double area()
    {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter()
    {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape
{
    double width, height;

    Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    @Override
    double area()
    {
        return width * height;
    }

    @Override
    double perimeter()
    {
        return 2 * (width + height);
    }
}

class Triangle extends Shape
{
    double a, b, c;

    Triangle(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double area()
    {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double perimeter()
    {
        return a + b + c;
    }
}

public class ShapeCalculator
{
    public static void main(String[] args)
    {
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(3));
        shapes.add(new Rectangle(4, 5));
        shapes.add(new Triangle(3, 4, 5));

        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName() + ":");
            System.out.println("  Area = " + s.area());
            System.out.println("  Perimeter = " + s.perimeter());
            System.out.println();
        }
    }
}

