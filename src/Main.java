import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        System.out.println("=====================================");
        System.out.println("    Welcome to TripMate Planner    ");
        System.out.println("=====================================");

        while (true) {
            System.out.println("1. User Dashboard");
            System.out.println("2. Admin Dashboard");
            System.out.print("Enter your choice (1 or 2): ");

            // Validate input
            if (sc.hasNextInt()) {
                choice = sc.nextInt();

                if (choice == 1) {
                    Dashboard.userDashboard();
                    break;
                } else if (choice == 2) {
                    AdminDashboard.adminDashboard();
                    break;
                } else {
                    System.out.println(" Invalid choice. Please enter 1 or 2.\n");
                }
            } else {
                System.out.println(" Please enter a valid number (1 or 2).\n");
                sc.next(); // Consume the invalid input
            }
        }

        sc.close();
    }
}
