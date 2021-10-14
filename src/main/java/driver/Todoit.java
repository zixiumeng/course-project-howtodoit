package driver;

import commands.CommandExecuter;

import java.util.Scanner;

/**
 * This is where our program will be run.
 */
public class Todoit {
    public static void main(String[] args) {
        // Initialize dataManager and commandExecuter
        DataManager dataManager = new DataManager();
        CommandExecuter commandExecuter = new CommandExecuter();
        CommandExecuter.COMMANDS = CommandExecuter.initializeCommands(dataManager);

        // Read data from local files
        dataManager.readData();

        // Let user type their commands and execute them
        Scanner in = new Scanner(System.in);
        while (true) {
            String userInput = in.nextLine();
            if (userInput.equals("Exit")) break;
            try {
                String output = commandExecuter.executeCommand(userInput);
                System.out.println(output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Write data into local files and exit the system
        dataManager.writeData();
    }
}
