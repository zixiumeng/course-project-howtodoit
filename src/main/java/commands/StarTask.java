package commands;

import driver.DataAccessor;
import todoSystem.Label;
import todoSystem.Task;
import todoSystem.TodoSystem;

public class StarTask implements Executable{
    /**
     * This function executes the star command: Add a task called <name> to Starred label
     * The task must already exist in the system.
     * @param args a String, representing user arguments
     * @return a String indicating a task has been added to Starred label
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to name
        String name = args[0];
        // Add the task to Starred
        Task task = todoSystem.getTasks().get(name);
        Label starred = todoSystem.getLabels().get("Starred");
        starred.addTask(task);

        return "Task added to Starred successfully.";
    }
}
