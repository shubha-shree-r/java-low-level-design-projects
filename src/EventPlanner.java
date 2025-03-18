import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EventPlanner {
    private ArrayList<Event> events;
    public void addEvent(Event event) {
        events.add(event);
    }


    public EventPlanner() {
        events = new ArrayList<>();
    }
    public static Event findEventByName(ArrayList<Event> events, String name) {
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }
    public static Event findEventByDate(ArrayList<Event> events, LocalDate date) {
        ArrayList<Event> sortedEvents = EventSorter.mergeSortByDate(events);

        int lowerBound = 0;
        int upperBound = sortedEvents.size() - 1;

        while (lowerBound <= upperBound) {
            int middleIndex = (lowerBound + upperBound) / 2;
            Event middleEvent = sortedEvents.get(middleIndex);
            int comparison = middleEvent.getDate().compareTo(date);

            if (comparison == 0) {
                return middleEvent;
            } else if (comparison < 0) {
                lowerBound = middleIndex + 1;
            } else {
                upperBound = middleIndex - 1;
            }
        }

        return null; // If the event is not found
    }
    public static void main(String[] args) {
        EventPlanner planner = new EventPlanner();
        ArrayList<Event> testEvents = new ArrayList<>(planner.getEvents());

        long bubbleSortTime = planner.measureAlgorithmPerformance(testEvents, "date", "bubble", true);
        long selectionSortTime = planner.measureAlgorithmPerformance(testEvents, "location", "selection", true);
        long insertionSortTime = planner.measureAlgorithmPerformance(testEvents, "name", "insertion", true);
        long mergeSortTime = planner.measureAlgorithmPerformance(testEvents, "date", "merge", true);
        long quickSortTime = planner.measureAlgorithmPerformance(testEvents, "location", "quick", true);

        long linearSearchTime = planner.measureAlgorithmPerformance(testEvents, "Birthday party", "name", false);
        long binarySearchTime = planner.measureAlgorithmPerformance(testEvents, "2023-09-20", "date", false);

        System.out.println("Bubble Sort Time: " + bubbleSortTime);
        System.out.println("Selection Sort Time: " + selectionSortTime);
        System.out.println("Insertion Sort Time: " + insertionSortTime);
        System.out.println("Merge Sort Time: " + mergeSortTime);
        System.out.println("Quick Sort Time: " + quickSortTime);

        System.out.println("Linear Search Time: " + linearSearchTime);
        System.out.println("Binary Search Time: " + binarySearchTime);
    }

    private int getEvents() {
        return 0;
    }

    public void deleteEvent(int index) {
        if (index >= 0 && index < events.size()) {
            events.remove(index);
        } else {
            System.out.println("Index out of bounds!");
        }
    }


    public ArrayList<Event> searchEvents(String searchTerm, String searchType) {
        ArrayList<Event> matchingEvents = new ArrayList<>();

        switch (searchType.toLowerCase()) {
            case "name":
                for (Event event : events) {
                    if (event.getName().equalsIgnoreCase(searchTerm)) {
                        matchingEvents.add(event);
                    }
                }
                break;


            default:
                System.out.println("Invalid search type!");
        }

        return matchingEvents;
    }
    public long measureAlgorithmPerformance(ArrayList<Event> eventList, String searchTerm, String searchType, boolean measureSorting) {
        long startTime = System.nanoTime();
        long elapsedTime = 0;

        if (measureSorting) {
            switch (searchType.toLowerCase()) {
                case "bubble":
                    EventSorter.bubbleSortByDate(eventList);
                    break;
                case "selection":
                    EventSorter.selectionSortByLocation(eventList);
                    break;
                case "insertion":
                    EventSorter.insertionSortByName(eventList);
                    break;
                case "merge":
                    EventSorter.mergeSortByDate(eventList);
                    break;
                case "quick":
                    EventSorter.quickSortByName(eventList);
                    break;
                default:
                    System.out.println("Invalid sorting type!");
                    return -1;
            }
        } else {
            searchEvents(searchTerm, searchType);
        }

        elapsedTime = System.nanoTime() - startTime;
        return elapsedTime;
    }

}
