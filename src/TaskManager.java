import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskManager {

    private ArrayList<Task> task;
    private Set<Task> uniqueTasks = new HashSet<>();
    private Map<String, List<Task>> tasksByCategory = new HashMap<>();

    public TaskManager(){
        task = new ArrayList<>();
    }

    public void addTask(Task tasks) throws TaskException {
        if (tasks.getTitle() == null || tasks.getTitle().isEmpty()) {
            throw new TaskException("Task name cannot be empty.");
        }
        task.add(tasks);
    }

    public void displayTask(){
        for(Task task : task){
            System.out.println("Title : " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Is Complete: " + (task.isComplete() ? "Yes" : "No"));
            System.out.println("---------------------------------------");

        }
    }


    public void maskTaskAsComplete(int taskIndex){
        Task selected = task.get(taskIndex);
        selected.isComplete();
    }

    public void removeTask(int index){
        if(index >= 0 && index < task.size()){
            task.remove(index);
            System.out.println("Task removed successfully!");
        }else{
            System.out.println(" Error: Invalid task index.");
        }
    }

    public void updateTask(int index, Task updatedTask) throws TaskException {
        if (index < 0 || index >= task.size()) {
            throw new TaskException("Task index out of range.");
        }
        task.set(index, updatedTask);
    }

    public void sortTask(Comparator<Task> comparator){
        Collections.sort(task,comparator);
    }

    public List<Task> searchTasks(Predicate<Task> searchCriteria){
        return task.stream().filter(searchCriteria).collect(Collectors.toList());
    }
    public void addTaskToSet(Task task) {
        uniqueTasks.add(task);
    }
    public Map<Integer, List<Task>> categorizeTasksByPriority() {
        return task.stream()
                .collect(Collectors.groupingBy(Task::getPriority, HashMap::new, Collectors.toList()));
    }
    public void addTaskToCategory(Task task, String category) {
        tasksByCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(task);
    }
    public List<Task> getTasksByCategory(String category) {
        return tasksByCategory.getOrDefault(category, new ArrayList<>());
    }
    public List<Task> filterTasksByCategory(String category) {
        return task.stream()
                .filter(task -> task.getTags().contains(category))
                .collect(Collectors.toList());
    }

    public void saveTasksToFile(String fileName) throws TaskException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Task task : task) {
                writer.write(task.toString() + "\n");
            }
        } catch (IOException e) {
            throw new TaskException("Error writing tasks to file: " + e.getMessage());
        }
    }


}
