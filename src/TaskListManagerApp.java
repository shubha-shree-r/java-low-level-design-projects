import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class TaskListManagerApp {
    public static void main(String[] args) throws TaskException {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to Task List Manager!");
            System.out.println("Available commands:");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Update task");
            System.out.println("4. View tasks");
            System.out.println("5. Save tasks to file");
            System.out.println("6. Load tasks from file");
            System.out.println("7. Exit");
            System.out.print("Enter your command (1-7): ");
            int command = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (command) {
                case 1:
                    // Add task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter tags: ");
                    String tags = scanner.nextLine();

                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline



// Create Task object with all four parameters
                    Task newTask = new Task(title,description,priority, Collections.singleton("work"));
                    taskManager.addTask(newTask);
                    System.out.println("Task added.");
                    break;
                case 2:
                    // Remove task
                    System.out.print("Enter task ID to remove: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    taskManager.removeTask(taskId);
                    System.out.println("Task removed.");
                    break;
                case 3:
                    // Update task
                    System.out.print("Enter task ID to update: ");
                    int taskToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter new task description: ");
                    Task newDes = null;
                    taskManager.updateTask(taskToUpdate, newDes);
                    System.out.println("Task updated.");
                    break;
                case 4:
                    // View tasks
                    System.out.println("Current tasks:");
                    taskManager.displayTask();
                    break;
                case 5:
                    // Save tasks to file
                    System.out.print("Enter file name to save tasks: ");
                    String fileNameToSave = scanner.nextLine();
                    taskManager.saveTasksToFile(fileNameToSave);
                    System.out.println("Tasks saved to file.");
                    break;

                case 6:
                    // Exit
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

}
