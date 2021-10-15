package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;

public class ModProj implements Executable{
    /**
     * This function executes the rnproj command: change a project’s name from <name1> to <name2>
     * The project must already exist in the system.
     * @param args a String, representing user arguments
     * @return a String indicating a project name has been changed
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args){
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to old name, new name
        String name1 = args[0];
        String name2 = args[1];
        // Get project and rename it
        Project project = todoSystem.getProjects().get(name1);
        project.setName(name2);

        return "Project renamed successfully.";
    }
}
