package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;

/**
 * This class deletes a completed task.
 */
public class CompleteTask implements Executable {

    /**
     * This function executes the completetask command: delete the task that's already finished
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 1, representing user arguments
     * @return a String indicating the completed task has been deleted.
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to task name
        String name = args[0];
        // Delete task from system
        todoSystem.delTask(name);

        return "Task <" + name + "> has been completed successfully.";
    }
}