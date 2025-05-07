package task_manager;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* The main class of the application for managing tasks via the console interface.
* Provides the user with a menu for interacting with the TaskManager.
*/
public class Main {
    public static void main(String[] args) throws Exception {
        Operation operation;

        do {
            operation = askOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);

    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Choose an action");
        ConsoleHelper.writeMessage(String.format("\t %d - Add task", Operation.ADD_TASK.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Delete task", Operation.DELETE_TASK.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Get all task", Operation.GET_ALL_TASKS.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Mark task as completed", Operation.MARK_TASK_AS_COMPLETE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - Exit", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }

}