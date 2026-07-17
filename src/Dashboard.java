import java.util.Scanner;

public class Dashboard {
    private static final Scanner scanner = new Scanner(System.in);

    // Manual Queue class for demonstration
    private static class MyQueue {
        private static class Node {
            String data;
            Node next;
            Node(String data) { this.data = data; }
        }

        private Node front, rear;

        public MyQueue() {
            front = rear = null;
        }

        public void enqueue(String data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public String dequeue() {
            if (front == null) return null;
            String data = front.data;
            front = front.next;
            if (front == null) rear = null;
            return data;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    public static void userDashboard() {
        // Example usage of queue - just for showing DS implemented
        MyQueue tripQueue = new MyQueue();

        while (true) {
            System.out.println("\n==== User Dashboard ====");
            System.out.println("1. Create New Trip");
            System.out.println("2. View Trip");
            System.out.println("3. Update Trip");
            System.out.println("4. Delete Trip");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Add created trip IDs to queue (fake example)
            if (choice == 1) {
                Trip trip = TripManager.createTrip();
                FileManager.saveTrip(trip);
                tripQueue.enqueue(trip.getUserId());  // Enqueue user ID
                System.out.println("\n Trip created successfully!");
                System.out.println("\n Generating your SCHEDULE...");
                ItineraryGenerator.generateItinerary(trip);
            } else if (choice == 2) {
                System.out.print("Enter User ID: ");
                String viewId = scanner.nextLine();
                Trip foundTrip = FileManager.readTripById(viewId);
                if (foundTrip != null) {
                    System.out.println(foundTrip);
                    System.out.println("\n SCHEDULE:");
                    ItineraryGenerator.generateItinerary(foundTrip);
                } else {
                    System.out.println("Trip not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter User ID to update: ");
                String updateId = scanner.nextLine();
                Trip updatedTrip = TripManager.createTrip();
                updatedTrip.setUserId(updateId);  // preserve original ID
                FileManager.updateTripById(updateId, updatedTrip);
                System.out.println("Trip updated successfully.");
            } else if (choice == 4) {
                System.out.print("Enter User ID to delete: ");
                String deleteId = scanner.nextLine();
                FileManager.deleteTripById(deleteId);
            } else if (choice == 5) {
                System.out.println("Exiting User Dashboard...");
                return;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
