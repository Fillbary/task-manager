package task_manager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A task manager responsible for adding, deleting, and managing tasks.
 * Provides thread-safe operations on a collection of tasks.
 */
public class Task {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final int id;
    private String title;
    private String description;
    private boolean isCompleted;


    public Task(String title,String description) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        this.id = idGenerator.getAndIncrement();
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isCompleted() {
        String status = "Not complete";
        if (isCompleted) {
            status = "Completed";
        }
        return status;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }
}
