package task_manager;

import task_manager.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> ALL_KNOWN_COMMANDS_MAP = new HashMap<>();

    static {
        ALL_KNOWN_COMMANDS_MAP.put(Operation.ADD_TASK, new AddTaskCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.DELETE_TASK, new DeleteTaskCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.GET_ALL_TASKS, new GetAllTasksCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.MARK_TASK_AS_COMPLETE, new MarkTaskAsCompleteCommand());
        ALL_KNOWN_COMMANDS_MAP.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {
    }

    public static void execute(Operation operation) throws Exception {
        ALL_KNOWN_COMMANDS_MAP.get(operation).execute();
    }
}
