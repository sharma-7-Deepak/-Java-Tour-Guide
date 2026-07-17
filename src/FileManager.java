import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "data/trips.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveTrip(Trip trip) {
        List<Trip> trips = readAllTrips();
        trips.add(trip);
        writeTripsToFile(trips);
    }

    public static List<Trip> readAllTrips() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || file.length() == 0) {
                return new ArrayList<>();
            }

            FileReader reader = new FileReader(file);
            return gson.fromJson(reader, new TypeToken<List<Trip>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static Trip readTripById(String userId) {
        for (Trip trip : readAllTrips()) {
            if (trip.getUserId().equalsIgnoreCase(userId)) {
                return trip;
            }
        }
        return null;
    }

    public static void updateTripById(String userId, Trip updatedTrip) {
        List<Trip> trips = readAllTrips();
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getUserId().equalsIgnoreCase(userId)) {
                trips.set(i, updatedTrip);
                writeTripsToFile(trips);
                return;
            }
        }
        System.out.println("Trip not found to update.");
    }

    public static void deleteTripById(String userId) {
        List<Trip> trips = readAllTrips();
        boolean removed = trips.removeIf(trip -> trip.getUserId().equalsIgnoreCase(userId));
        if (removed) {
            writeTripsToFile(trips);
            System.out.println("Trip deleted successfully.");
        } else {
            System.out.println("Trip not found.");
        }
    }

    private static void writeTripsToFile(List<Trip> trips) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(trips, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
