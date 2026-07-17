import java.util.Scanner;
import java.util.UUID;//generate kre ga unique User ID using UUID.randomUUID().

public class TripManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static Trip createTrip() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("\nSelect region:");
        System.out.println("1. North");
        System.out.println("2. South");
        System.out.println("3. East");
        System.out.println("4. West");
        System.out.print("Enter choice: ");
        int regionChoice = scanner.nextInt();
        scanner.nextLine();

        String region = "";
        switch (regionChoice) {
            case 1: region = "North"; break;
            case 2: region = "South"; break;
            case 3: region = "East";  break;
            case 4: region = "West";  break;
            default:
                System.out.println("Invalid region. Defaulting to North.");
                region = "North";
        }

        System.out.println("\nAvailable cities in " + region + ":");
        CityData.printCitiesByRegion(region);
        System.out.print("Enter city to visit: ");
        String city = scanner.nextLine();

        System.out.print("Enter start date (DD/MM/YYYY): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (DD/MM/YYYY): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter trip budget (Rs): ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        String userId = UUID.randomUUID().toString().substring(0, 8); // generate 8-char user ID
        System.out.println("Your UserID is: "+ userId);
        return new Trip(userId, userName, region, city, startDate, endDate, budget);
    }
}
