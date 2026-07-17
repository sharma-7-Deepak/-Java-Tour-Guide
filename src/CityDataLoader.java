import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class CityDataLoader {
    private static final String CITY_FILE = "data/cities.json";

    public static List<String> getPlacesForCity(String cityName) {
        try (FileReader reader = new FileReader(CITY_FILE)) {
            Gson gson = new Gson();
            Map<String, List<String>> cityMap = gson.fromJson(reader, new TypeToken<Map<String, List<String>>>() {}.getType());
            return cityMap.getOrDefault(cityName, new ArrayList<>());
        } catch (Exception e) {
            System.out.println("Error loading city data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}