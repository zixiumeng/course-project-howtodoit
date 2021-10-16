package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;

/**
 * This class deletes a label.
 */
public class DelLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to label name
        String name = args[0];
        // Delete this label from our system
        todoSystem.delLab(name);

        return "Label <" + name + "> has been removed successfully.";
    }
}