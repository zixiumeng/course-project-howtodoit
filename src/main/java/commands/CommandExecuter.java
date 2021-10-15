package commands;

import constants.Commands;

import java.util.*;

/**
 * This class initializes and executes commands.
 */
public class CommandExecuter {
    /**
     *
     * @param userInput exactly what the user typed
     * @return whatever String is returned by the specific command executed
     * @throws Exception when command is not found or when arguments are invalid
     */
    public String executeCommand(String userInput) throws Exception {
        String[] inputArray = userInput.split(";"); // Use ";" to split user input String
        String userCommandName = inputArray[0];
        // Get the corresponding command object
        Executable command  = Commands.COMMANDS.getOrDefault(userCommandName, null);
        if (command != null) {
            String[] args = Arrays.copyOfRange(inputArray, 1, inputArray.length); // Get user arguments
            return command.execute(args); // Execute the command
        } else {
            throw new Exception("Command not found!");
        }
    }
}
