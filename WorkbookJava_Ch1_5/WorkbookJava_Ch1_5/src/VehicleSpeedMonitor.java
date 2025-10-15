import java.util.Scanner;

public class VehicleSpeedMonitor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter vehicle type (Car, Bus, Bike): ");
            String vehicleType = sc.nextLine().trim();

            System.out.print("Enter speed: ");
            int speed = sc.nextInt();
            sc.nextLine();

            if (speed < 0)
            {
                System.out.println("Exiting system…");
                break;
            }

            int speedLimit = switch (vehicleType.toLowerCase())
            {
                case "car" -> 100;
                case "bus" -> 80;
                case "bike" -> 60;
                default -> -1;
            };

            if (speedLimit == -1)
            {
                System.out.println("Unknown vehicle type");
            } else if (speed <= speedLimit)
            {
                System.out.println("Speed OK");
            } else
            {
                System.out.println("Speeding!");
            }
            System.out.println();
        }
        sc.close();
    }
}

