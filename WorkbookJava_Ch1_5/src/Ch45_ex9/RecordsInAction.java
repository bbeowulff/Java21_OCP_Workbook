package Ch45_ex9;

import java.util.List;

record Person(String name, int age)
{
    public Person
    {
        if (age < 0)
        {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    @Override
    public String toString()
    {
        return name + " (" + age + " years old)";
    }
}

public class RecordsInAction
{
    public static void main(String[] args)
    {
        List<Person> people = List.of(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        );

        for (Person p : people)
        {
            System.out.println(p);
        }
        System.out.println();
    }
}

