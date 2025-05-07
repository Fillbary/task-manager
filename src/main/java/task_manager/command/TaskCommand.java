package task_manager.command;

import task_manager.TaskManager;

public abstract class TaskCommand implements Command{
    public TaskManager getTaskManager() throws Exception {
        return new TaskManager();
    }
}
