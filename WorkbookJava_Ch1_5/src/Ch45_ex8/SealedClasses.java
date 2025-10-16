package Ch45_ex8;

sealed class Transport permits Car, Bike, Bus
{
    String brand;

    Transport(String brand)
    {
        this.brand = brand;
    }

    void move()
    {
        System.out.println(brand + " is moving...");
    }
}

final class Car extends Transport
{
    int doors;

    Car(String brand, int doors)
    {
        super(brand);
        this.doors = doors;
    }

    @Override
    void move()
    {
        System.out.println(brand + " car with " + doors + " doors is driving on the road.");
    }
}

final class Bike extends Transport
{
    boolean hasHelmet;

    Bike(String brand, boolean hasHelmet)
    {
        super(brand);
        this.hasHelmet = hasHelmet;
    }

    @Override
    void move()
    {
        System.out.println(brand + " bike is being pedaled. Helmet: " + hasHelmet);
    }
}

final class Bus extends Transport
{
    int capacity;

    Bus(String brand, int capacity)
    {
        super(brand);
        this.capacity = capacity;
    }

    @Override
    void move()
    {
        System.out.println(brand + " bus with capacity " + capacity + " passengers is driving.");
    }
}

public class SealedClasses
{
    public static void main(String[] args)
    {
        Transport car = new Car("Toyota", 4);
        Transport bike = new Bike("Trek", true);
        Transport bus = new Bus("Volvo", 50);

        car.move();
        bike.move();
        bus.move();

        Transport[] transports = {car, bike, bus};
        for (Transport t : transports)
        {
            t.move();
        }
    }
}
