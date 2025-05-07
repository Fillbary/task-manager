package task_manager.command;

import task_manager.ConsoleHelper;
import task_manager.TaskManager;

public class MarkTaskAsCompleteCommand extends TaskCommand{
    @Override
    public void execute() throws Exception {
        //TaskManager taskManager = getTaskManager();
        ConsoleHelper.writeMessage("Enter the task ID you want to mark as completed:");
        int completeTaskID = ConsoleHelper.readInt();
        String title = TaskManager.getTasks().get(completeTaskID - 1).getTitle();

        TaskManager.markTaskAsCompleted(completeTaskID);
        ConsoleHelper.writeMessage(String.format("You have marked the task with ID: %d title: %s as completed", completeTaskID, title));
    }
}
