import java.util.List;
import java.util.Scanner;

public class AdminDashboard {
    private static final Scanner sc = new Scanner(System.in);

    // Manual Stack class for demonstration
    private static class MyStack {
        private static class Node {
            String data;
            Node next;
            Node(String data) { this.data = data; }
        }

        private Node top;

        public MyStack() {
            top = null;
        }

        public void push(String data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public String pop() {
            if (top == null) return null;
            String data = top.data;
            top = top.next;
            return data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void adminDashboard() {
        // Example usage of stack - just to show DS implemented
        MyStack deletedTripsStack = new MyStack();

        while (true) {
            System.out.println("\n==== Admin Dashboard ====");
            System.out.println("1. View All Trips");
            System.out.println("2. Delete Trip by User ID");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                List<Trip> allTrips = FileManager.readAllTrips();
                if (allTrips.isEmpty()) {
                    System.out.println("No trips found.");
                } else {
                    for (Trip trip : allTrips) {
                        System.out.println("\n----------------------------------");
                        System.out.println(trip);
                        System.out.println(" SCHEDULE:");
                        ItineraryGenerator.generateItinerary(trip);
                        System.out.println("----------------------------------");
                    }
                }
            } else if (choice == 2) {
                System.out.print("Enter User ID to delete: ");
                String deleteId = sc.nextLine();
                FileManager.deleteTripById(deleteId);
                deletedTripsStack.push(deleteId);  // Push deleted ID on stack
            } else if (choice == 3) {
                System.out.println("Exiting Admin Dashboard...");
                return;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
