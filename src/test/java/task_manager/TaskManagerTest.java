package task_manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    //Test added a task
    @Test
    void addTask_ShouldIncreaseTaskListSize() {
        //Given
        String title = "title";
        String description = "description";
        int initialSize = taskManager.getAllTasks().size();

        //When
        taskManager.addTask(title, description);

        //Then
        assertEquals(initialSize + 1, taskManager.getAllTasks().size(),
                "The task list size should increase by 1");
    }

    //Test delete a task
    @Test
    void deleteTask_ShouldDecreaseTaskListSize() {
        //Given
        taskManager.addTask("title", "desc");
        int taskID =  taskManager.getAllTasks().get(0).getID();
        int initialSize = taskManager.getAllTasks().size();

        //When
        taskManager.deleteTask(taskID);

        //Then
        assertEquals(initialSize-1, taskManager.getAllTasks().size(),
                "The size of the task list should decrease by 1");
    }

    //Test for deleting a non-existent task
    @Test
    void deleteNonExistentTask_ShouldThrowException_WhenTaskNotExists() {
        //Given
        int nonExistedTaskID = 999;

        //When & Then
        assertThrows(NoSuchElementException.class,
                () -> taskManager.deleteTask(nonExistedTaskID),
                "\"NoSuchElementException should be thrown\"");
    }

    //Test for marking a task as completed
    @Test
    void markingTaskAsCompleted_ShouldChangeTaskStatus() {
        //Given
        taskManager.addTask("title", "description");
        int taskID =  taskManager.getAllTasks().get(0).getID();

        //When
        taskManager.markTaskAsCompleted(taskID);

        //Then
        assertEquals("Completed", taskManager.getAllTasks().get(0).isCompleted(),
                "Task status should change to complete");
    }

    //Test for marking a non-existent task
    @Test
    void markingNonExistedTaskAsComplete_ShouldThrowException_WhenTaskNotExists() {
        //Given
        int nonExistedTask = 999;

        //When & Then
        assertThrows(NoSuchElementException.class,
                () -> taskManager.markTaskAsCompleted(nonExistedTask),
                "\"NoSuchElementException should be thrown\"");
    }
}
