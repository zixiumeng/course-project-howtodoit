package commands;

import driver.DataAccessor;

import java.util.*;

/**
 * This class initializes and executes commands.
 */
public class CommandExecuter {
    public static HashMap<String, Executable> COMMANDS;

    /**
     *
     * @param userInput exactly what the user typed
     * @return whatever String is returned by the specific command executed
     * @throws Exception when command is not found or when arguments are invalid
     */
    public String executeCommand(String userInput) throws Exception {
        Executable command  = this.findCommand(userInput);
        String[] args = this.getArguments(userInput);
        return command.execute(args);
    }

    /**
     * This class initializes all commands.
     * @param dataAccessor the interface that provides access to entities, essential to use cases (commands)
     * @return a map of command names to Executable objects
     */
    public static HashMap<String, Executable> initializeCommands(DataAccessor dataAccessor) {
        HashMap<String, Executable> commands = new HashMap<>();
        commands.put("New", new New(dataAccessor));
        // TODO: add more commands and create those classes!
        return commands;
    }

    private Executable findCommand(String userInput) throws Exception {
        return null;
    }

    private String[] getArguments(String userInput) throws Exception {
        return null;
    }
}
