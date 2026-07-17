import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class CityData {
    private static final String CITY_FILE = "data/cities.json";
    private static Map<String, List<City>> regionCityMap = new HashMap<>();

    static {
        loadCityData();
    }

    private static void loadCityData() {
        try {
            FileReader reader = new FileReader(CITY_FILE);
            Map<String, List<City>> data = new Gson().fromJson(reader, new TypeToken<Map<String, List<City>>>() {}.getType());
            if (data != null) {
                regionCityMap = data;
            } else {
                System.out.println(" Could not load city data. File might be empty or corrupt.");
            }
        } catch (Exception e) {
            System.out.println(" Error reading city data: " + e.getMessage());
        }
    }

    public static void printCitiesByRegion(String region) {
        List<City> cities = regionCityMap.get(region);
        if (cities != null) {
            for (City city : cities) {
                System.out.println(" " + city.getName());
            }
        } else {
            System.out.println(" No cities found for region: " + region);
        }
    }

    public static List<String> getFamousPlaces(String region, String cityName) {
        List<City> cities = regionCityMap.get(region);
        if (cities != null) {
            for (City city : cities) {
                if (city.getName().equalsIgnoreCase(cityName)) {
                    return city.getFamousPlaces();
                }
            }
        }
        return Collections.emptyList();
    }

    public static class City {
        private String name;
        private List<String> famousPlaces;

        public String getName() {
            return name;
        }

        public List<String> getFamousPlaces() {
            return famousPlaces;
        }
    }
}