package task_manager.command;

import task_manager.ConsoleHelper;
import task_manager.TaskManager;

public class AddTaskCommand extends TaskCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("You have chosen to add a task");
        ConsoleHelper.writeMessage("Enter a task title:");
        String title = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Enter a task description (optional) : ");
        String description = ConsoleHelper.readString();

        if (TaskManager.getTasks() == null || TaskManager.getTasks().size() == 0) {
            TaskManager taskManager = getTaskManager();
            taskManager.addTask(title, description);
        } else {
            TaskManager.addTask(title, description);
        }

        ConsoleHelper.writeMessage("Task: " + title + " successfully added! \n");
    }
}
