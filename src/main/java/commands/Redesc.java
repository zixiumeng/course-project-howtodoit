package commands;

import driver.DataAccessor;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 * This class updates the description of a task.
 */
public class Redesc implements Executable {

    /**
     * This function executes the redesc command: change the description of a task
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task's description has been updated
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and new description
        String name = args[0];
        String newdesc = args[1];
        // Get task and change its description
        Task task = todoSystem.getTasks().get(name);
        task.setDescription(newdesc);

        return "The description of task <" + name + "> has been updated successfully.";
    }
}