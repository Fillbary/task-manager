package task_manager.command;

import task_manager.ConsoleHelper;
import task_manager.TaskManager;

public class GetAllTasksCommand extends TaskCommand{

    @Override
    public void execute() throws Exception {
        //TaskManager taskManager = getTaskManager();
        ConsoleHelper.writeMessage("Here is the list of current tasks: \n");
        TaskManager.getAllTasks();
    }
}
