import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event("Conference", LocalDate.of(2023, 5, 15), "New York"));
        events.add(new Event("Birthday Party", LocalDate.of(2023, 5, 12), "Los Angeles"));
        events.add(new Event("Meeting", LocalDate.of(2023, 5, 10), "San Francisco"));

        System.out.println("Before sorting:");
        for (Event event : events) {
            System.out.println(event);
        }

        EventSorter.insertionSortByName(events);

        System.out.println("\nAfter sorting:");
        for (Event event : events) {
            System.out.println(event);
        }
    }}
