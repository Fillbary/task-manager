package task_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Менеджер задач, отвечающий за добавление, удаление и управление задачами.
 * Обеспечивает потокобезопасные операции с коллекцией задач.
 */
public class TaskManager {
    private static List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void addTask(String title, String description) {

        if (title == null || title.equals("")) {
            throw new IllegalArgumentException("The title cannot be empty or null");
        }
        Task task = new Task(title, description);
        tasks.add(task);
    }

    public static void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getID() == id) {
                tasks.remove(task);
                return;
            }
        }
        throw new NoSuchElementException("Task with ID " + id + " not found");
    }

    public static List<Task> getAllTasks() {
        for (Task task : tasks) {
            if (tasks.isEmpty()) {
                ConsoleHelper.writeMessage("List is empty");
            } else {
                String template = "Task id: %d title: %s \n description: %s \n status: %s \n";
                ConsoleHelper.writeMessage(String.format(template, task.getID(), task.getTitle(), task.getDescription(), task.isCompleted()));
            }
            ConsoleHelper.writeMessage("____________________\n");
        }
        return tasks;
    }

    public static void markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if(task.getID() == id) {
                task.markAsCompleted();
                return;
            }
        }
        throw new NoSuchElementException("Task id: " + id + " not found");
    }
}
