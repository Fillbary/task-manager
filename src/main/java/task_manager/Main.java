package task_manager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
* The main class of the application for managing tasks via the console interface.
* Provides the user with a menu for interacting with the TaskManager.
*/
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                running = handlerUserChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a number between 1 and 5");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Choose an action \n" +
                        "1. Add task\n" +
                        "2. Delete task\n" +
                        "3. Get all task\n" +
                        "4. Mark task as completed\n" +
                        "5. Exit\n" +
                        "___________________");
    }

    public static boolean handlerUserChoice(int choice) throws InterruptedException {
        switch (choice) {
                    case(1):
                        addTask();
                        Thread.sleep(1000);
                        break;
                    case(2):
                        deleteTask();
                        Thread.sleep(1000);
                        break;
                    case(3):
                        getAllTasks();
                        Thread.sleep(1000);
                        break;
                    case(4):
                        markTaskAsComplete();
                        Thread.sleep(1000);
                        break;
                    case(5):
                        System.out.println("You have left the action menu");
                        Thread.sleep(1000);
                        return false;
                    default:
                        System.out.println("Wrong choice. Try again.");
                }
        return true;
    }

    public static void addTask() {
        System.out.println("You have chosen to add a task");
        System.out.println("Enter a task title:");
        String title = scanner.nextLine();

        System.out.println("Enter a task description (optional) : ");
        String description = scanner.nextLine();

        taskManager.addTask(title, description);
        System.out.println("Task: " + title + " successfully added! \n");
    }

    public static void deleteTask() {
        System.out.println("You have chosen to delete a task");
        System.out.println("Enter a task id: ");
        int deleteTaskId = scanner.nextInt();

        taskManager.deleteTask(deleteTaskId);
        System.out.println("Task ID:" + deleteTaskId + " deleted\n");
    }

    public static void getAllTasks() {
        System.out.println("Here is the list of current tasks: \n");
        taskManager.getAllTasks();
    }

    public static void markTaskAsComplete() {
        System.out.println("Enter the task ID you want to mark as completed:");
        int completeTaskID = scanner.nextInt();
        String title = taskManager.getTasks().get(completeTaskID - 1).getTitle();

        taskManager.markTaskAsCompleted(completeTaskID);
        System.out.format("You have marked the task with ID: %d and title: %s as completed \n", completeTaskID, title);
    }
}