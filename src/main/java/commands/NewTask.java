package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 *
 */
public class NewTask implements Executable {

    /**
     * This function executes the newtask command: create a new task with given params and add it to Inbox.
     * @param args a list of Strings with length 3, representing user arguments to the New command
     * @return a String indicating a new task has been added successfully
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to name, dueDate, description
        String name = args[0];
        String dueDate = args[1];
        String description = args[2];
        // Create a new task with name, dueDate, and description, and add it to Inbox
        Project inbox = todoSystem.getProjects().get("Inbox"); // Get Inbox
        Task task = new Task(name, dueDate, description, inbox);
        todoSystem.getTasks().put(name, task);
        inbox.addTask(task);

        return "Task added successfully.";
    }

    private void checkArgs(TodoSystem todoSystem, String[] args) throws Exception {
        if (args.length != 3) {
            throw new Exception("Wrong argument length.");
        } else if (todoSystem.getTasks().containsKey(args[0])) {
            throw new Exception("Task (with the same name) already exists.");
        } // TODO: check whether due date is valid
    }
}
