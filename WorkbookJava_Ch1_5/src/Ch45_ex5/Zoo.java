package Ch45_ex5;

import java.util.ArrayList;

class Animal
{
    void makeSound()
    {
        System.out.println("Animal sound");
    }
}

class Mammal extends Animal
{
    @Override
    void makeSound()
    {
        System.out.println("Generic mammal sound");
    }
}

class Bird extends Animal
{
    @Override
    void makeSound()
    {
        System.out.println("Generic bird sound");
    }
}

class Dog extends Mammal
{
    @Override
    void makeSound()
    {
        System.out.println("Woof!");
    }
}

class Eagle extends Bird
{
    @Override
    void makeSound()
    {
        System.out.println("Screech!");
    }
}

public class Zoo
{
    public static void main(String[] args)
    {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Dog());
        animals.add(new Eagle());
        animals.add(new Mammal());
        animals.add(new Bird());

        for (Animal a : animals)
        {
            a.makeSound();

            if (a instanceof Dog)
            {
                System.out.println("→ It's a dog!");
            } else if (a instanceof Eagle)
            {
                System.out.println("→ It's an eagle!");
            }
        }
    }
}

