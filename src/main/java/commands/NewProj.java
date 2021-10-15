package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;

public class NewProj implements Executable {

    /**
     * This function executes the mkproj command: create a new project with given params.
     * The project must not already exist in the system.
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating a new project has been created successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to name
        String name = args[0];
        // Create a new project and add it to our system
        Project proj = new Project(name, true);
        todoSystem.getProjects().put(name, proj);
        return "Project added successfully.";
    }
}
