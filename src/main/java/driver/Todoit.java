package driver;

import commands.CommandExecuter;
import constants.Commands;
import constants.FilePaths;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is where our program will be run.
 */
public class Todoit {
    public static void main(String[] args) {
        // Initialize dataManager and commandExecuter
        DataManager dataManager = new DataManager();
        CommandExecuter commandExecuter = new CommandExecuter();
        Commands.loadCommands(dataManager);

        // Initialize data files using pre-defined file paths
        File projectsFile = new File(FilePaths.projectsPath);

        // Read data from local files
        try {
            dataManager.readData(projectsFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

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
        try {
            dataManager.writeData(projectsFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
