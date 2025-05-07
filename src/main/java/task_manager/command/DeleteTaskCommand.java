package task_manager.command;

import task_manager.ConsoleHelper;
import task_manager.TaskManager;

public class DeleteTaskCommand extends TaskCommand{
    @Override
    public void execute() throws Exception {
        //TaskManager taskManager = getTaskManager();
        ConsoleHelper.writeMessage("You have chosen to delete a task");
        ConsoleHelper.writeMessage("Enter a task id: ");
        int deleteTaskId = ConsoleHelper.readInt();

        TaskManager.deleteTask(deleteTaskId);
        ConsoleHelper.writeMessage("Task ID:" + deleteTaskId + " deleted\n");
    }
}
