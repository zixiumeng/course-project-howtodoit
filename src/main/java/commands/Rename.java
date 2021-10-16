package commands;

import driver.DataAccessor;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 * This class renames a task.
 */
public class Rename implements Executable{

    /**
     * This function executes the rename command: Change the name of a task from <name1> to <name2>
     * The task must already exist in the system.
     * @param args a list of Strings with length 2, representing user arguments
     * @return a String indicating a task has been renamed
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to old name, new name
        String name1 = args[0];
        String name2 = args[1];
        // Get task and rename it
        Task task = todoSystem.getTasks().get(name1);
        task.setName(name2);

        return "Task renamed successfully.";
    }

}

