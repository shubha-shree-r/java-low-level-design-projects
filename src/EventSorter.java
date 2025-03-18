import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class EventSorter {

    public static void bubbleSortByDate(ArrayList<Event> events) {
        int n = events.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (events.get(j).getDate().isAfter(events.get(j + 1).getDate())) {
                    // Swap the events
                    Event temp = events.get(j);
                    events.set(j, events.get(j + 1));
                    events.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the list is already sorted
            if (!swapped) break;
        }
    }

    public static void selectionSortByLocation(ArrayList<Event> events) {
        int n = events.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (events.get(j).getLocation().compareTo(events.get(minIndex).getLocation()) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                Event temp = events.get(minIndex);
                events.set(minIndex, events.get(i));
                events.set(i, temp);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();

        events.add(new Event("Conference",  LocalDate.of(2023, 6, 15), "New York"));
        events.add(new Event("Birthday Party",  LocalDate.of(2023, 6, 15),"New york"));
        events.add(new Event("Meeting",  LocalDate.of(2023, 6, 15), "San Francisco"));

        System.out.println("Before sorting:");
        for (Event event : events) {
            System.out.println(event);
        }

        selectionSortByLocation(events);

        System.out.println("\nAfter sorting:");
        for (Event event : events) {
            System.out.println(event);
        }
    }
    public static void insertionSortByName(ArrayList<Event> events) {
        for (int i = 1; i < events.size(); i++) {
            Event key = events.get(i);
            String keyName = key.getName();
            int j = i - 1;

            while (j >= 0 && events.get(j).getName().compareTo(keyName) > 0) {
                events.set(j + 1, events.get(j));
                j--;
            }
            events.set(j + 1, key);
        }
    }
    public static ArrayList<Event> mergeSortByDate(ArrayList<Event> events) {
        return mergeSortByDateHelper(events, 0, events.size() - 1);
    }

    private static ArrayList<Event> mergeSortByDateHelper(ArrayList<Event> events, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            ArrayList<Event> leftSorted = mergeSortByDateHelper(events, left, middle);
            ArrayList<Event> rightSorted = mergeSortByDateHelper(events, middle + 1, right);

            return merge(leftSorted, rightSorted);
        } else {
            ArrayList<Event> singleElementList = new ArrayList<>();
            singleElementList.add(events.get(left));
            return singleElementList;
        }
    }
    private static ArrayList<Event> merge(ArrayList<Event> leftSorted, ArrayList<Event> rightSorted) {
        ArrayList<Event> merged = new ArrayList<>();

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftSorted.size() && rightIndex < rightSorted.size()) {
            if (leftSorted.get(leftIndex).getDate().isBefore(rightSorted.get(rightIndex).getDate())) {
                merged.add(leftSorted.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(rightSorted.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < leftSorted.size()) {
            merged.add(leftSorted.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < rightSorted.size()) {
            merged.add(rightSorted.get(rightIndex));
            rightIndex++;
        }

        return merged;
    }
    public static ArrayList<Event> quickSortByName(ArrayList<Event> events) {
        ArrayList<Event> sortedEvents = new ArrayList<>(events);
        quickSortByNameHelper(sortedEvents, 0, sortedEvents.size() - 1);
        return sortedEvents;
    }
    private static void quickSortByNameHelper(ArrayList<Event> events, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(events, left, right);

            quickSortByNameHelper(events, left, pivotIndex - 1);
            quickSortByNameHelper(events, pivotIndex + 1, right);
        }
    }
    private static int partition(ArrayList<Event> events, int left, int right) {
        int pivotIndex = right;
        Event pivot = events.get(pivotIndex);
        right--;

        while (true) {
            while (left <= right && events.get(left).getName().compareTo(pivot.getName()) < 0) {
                left++;
            }

            while (right >= left && events.get(right).getName().compareTo(pivot.getName()) > 0) {
                right--;
            }

            if (left <= right) {
                Collections.swap(events, left, right);
                left++;
                right--;
            } else {
                break;
            }
        }

        Collections.swap(events, left, pivotIndex);
        return left;
    }
}
