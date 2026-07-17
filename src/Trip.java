public class Trip {
    private String userId;
    private String userName;
    private String region;
    private String city;
    private String startDate; // format: DD/MM/YYYY
    private String endDate;
    private double budget;

    // Default constructor (required for JSON deserialization)
    public Trip() {
    }

    public Trip(String userId, String userName, String region, String city, String startDate, String endDate, double budget) {
        this.userId = userId;
        this.userName = userName;
        this.region = region;
        this.city = city;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", budget=" + budget +
                '}';
    }
}
