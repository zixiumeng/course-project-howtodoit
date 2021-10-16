package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;

public class NewLab implements Executable {

    /**
     * This function executes the newlab command: create a new label with given params.
     * The label must not already exist in the system.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a new label has been created successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to name
        String name = args[0];
        // Add new label to our system
        todoSystem.addLab(name);
        return "Label <" + name + "> has been added successfully.";
    }
}