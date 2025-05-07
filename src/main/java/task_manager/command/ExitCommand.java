package task_manager.command;

import task_manager.ConsoleHelper;

public class ExitCommand extends TaskCommand{
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("You have left the action menu");
    }
}
