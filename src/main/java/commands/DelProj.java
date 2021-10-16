package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;

/**
 * This class deletes a project.
 */
public class DelProj implements Executable {
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to project name
        String name = args[0];
        // Delete this project
        todoSystem.delProj(name);

        return "Project <" + name + "> has been removed and all tasks have been added into inbox successfully.";
    }
}