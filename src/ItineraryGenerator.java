import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ItineraryGenerator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Manual Node class for Linked List
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class MyLinkedList {
        private Node head;
        private int size;

        MyLinkedList() {
            head = null;
            size = 0;
        }

        public void add(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        public String get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        public int size() {
            return size;
        }
    }

    public static void generateItinerary(Trip trip) {
        List<String> places = CityData.getFamousPlaces(trip.getRegion(), trip.getCity());

        if (places.isEmpty()) {
            System.out.println(" No famous places found for the selected city.");
            return;
        }

        MyLinkedList itineraryList = new MyLinkedList();
        for (String place : places) {
            itineraryList.add(place);
        }

        LocalDate start = LocalDate.parse(trip.getStartDate(), FORMATTER);
        LocalDate end = LocalDate.parse(trip.getEndDate(), FORMATTER);
        int days = (int) (end.toEpochDay() - start.toEpochDay()) + 1;

        System.out.println("\n==================== YOUR SCHEDULE ====================");

        int placeIndex = 0;
        for (int i = 0; i < days; i++) {
            LocalDate current = start.plusDays(i);
            System.out.println("==================================================");
            System.out.println("               SCHEDULE FOR " + FORMATTER.format(current));
            System.out.println("==================================================");

            // Starting Point
            if (placeIndex < itineraryList.size()) {
                System.out.println("\n STARTING POINT:");
                System.out.println("    " + itineraryList.get(placeIndex++) + " - 09:30 AM");
            }

            // Breakfast
            System.out.println("\n BREAKFAST");
            System.out.println("    Location : Nearby Food Court");
            System.out.println("    Time     : 09:30 AM");
            System.out.println("    Cost     : Rs.100");

            // Visit 2 more places during the day
            for (int j = 0; j < 2 && placeIndex < itineraryList.size(); j++) {
                String from;
                if (j == 0) {
                    from = "Breakfast Point";
                } else {
                    from = itineraryList.get(placeIndex - 1);
                }

                String to = itineraryList.get(placeIndex);
                System.out.println("\n TRAVEL");
                System.out.println("    From     : " + from);
                System.out.println("    To       : " + to);
                System.out.println("    ETA      : " + (10 + j * 2) + ":15 AM");

                System.out.println("\n VISIT");
                System.out.println("    Place    : " + to);
                System.out.println("    Time     : " + (10 + j * 2) + ":15 AM - " + (11 + j * 2) + ":30 AM");
                System.out.println("    Entry    : Rs.50");

                placeIndex++;
            }

            System.out.println(); // Space between days
        }

        System.out.println("==================================================");
        System.out.println(" Trip Duration: " + days + " day(s), City: " + trip.getCity());
        System.out.println("==================================================\n");
    }
}
