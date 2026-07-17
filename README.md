# TripMate (Java Tour Guide)

TripMate is a console-based Java application designed to help users plan their travel itineraries. Users can define their personal details, trip budget, duration, and target destination (region and city). Based on these inputs, TripMate generates a detailed day-by-day travel schedule, showcasing famous local attractions, estimated visit times, transportation details, and cost logs.

---

## 🚀 Features

### 👤 User Dashboard
* **Create New Trip**: Set up a trip by selecting a region, city, dates, budget, and userName.
* **View Trip & Itinerary**: Retrieve your trip details and view a generated day-wise itinerary.
* **Update Trip**: Modify existing trip parameters while retaining your original user ID.
* **Delete Trip**: Cancel and delete an existing trip plan.

### 🔑 Admin Dashboard
* **View All Trips**: Review a list of all user trips logged in the system along with their itineraries.
* **Delete User Trip**: Remove any trip from the system by specifying the User ID.

### 🧠 Data Structures Implemented (Manual)
To demonstrate core data structure concepts without using built-in Java Collections:
* **Custom Queue (`MyQueue`)**: A FIFO queue implemented inside the `Dashboard` to track user trip creation flows.
* **Custom Stack (`MyStack`)**: A LIFO stack implemented inside the `AdminDashboard` to track deleted trips.
* **Custom Linked List (`MyLinkedList`)**: A singly linked list inside `ItineraryGenerator` to sequence and traverse destinations sequentially day-by-day.

---

## 📁 Project Structure

```text
TripMate/
├── data/
│   ├── cities.json           # JSON Database of regions, cities, and famous attractions
│   └── trips.json            # JSON Database of saved user trips
├── lib/
│   └── gson-2.8.9.jar        # Gson library dependency for JSON serialization
├── src/
│   ├── Main.java             # Entry point (CLI Main menu)
│   ├── Dashboard.java        # User dashboard CLI & custom Queue implementation
│   ├── AdminDashboard.java   # Admin dashboard CLI & custom Stack implementation
│   ├── Trip.java             # Trip model (properties, getters, setters)
│   ├── TripManager.java      # CLI input handler for trip creation
│   ├── CityData.java         # Handler for loading and querying city datasets
│   ├── ItineraryGenerator.java# Logic for generating itineraries using custom Linked List
│   ├── FileManager.java      # JSON file persistence operations (CRUD)
│   └── ER.puml               # PlantUML Entity Relationship Diagram
├── diagrams.puml             # PlantUML Class Diagram
└── .gitignore                # Git configuration ignoring build outputs and IDE files
```

---

## 🛠️ Tech Stack & Dependencies

* **Language**: Java (JDK 8 or later recommended)
* **Libraries**: Google Gson (v2.8.9) for file serialization and deserialization
* **Data Storage**: JSON-based flat files (`data/cities.json` and `data/trips.json`)

---

## ⚙️ How to Build and Run

### Prerequisites
Make sure you have JDK installed and added to your system's PATH.

### 1. Compile the Project
From the root of the project directory (`TripMate/`), run:

```bash
# Windows / Linux / macOS
javac -cp "lib/*" -d out src/*.java
```

### 2. Run the Application
Run the compiled classes, including the library dependencies in the classpath:

**On Windows:**
```cmd
java -cp "out;lib/*" Main
```

**On Linux / macOS:**
```bash
java -cp "out:lib/*" Main
```

---

## 📊 Design & Architecture
A PlantUML Class Diagram representing the system architecture is provided in the root as [diagrams.puml](diagrams.puml). It maps out the custom nodes, nested data structures, and the relationships between control dashboards and the data storage layer.