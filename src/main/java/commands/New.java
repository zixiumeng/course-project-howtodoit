package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.Task;
import todoSystem.TodoSystem;

/**
 *
 */
public class New implements Executable {
    private final DataAccessor dataAccessor;

    public New(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    /**
     * This function executes the New command: create a new task with given params and add it to Inbox.
     * If the same task (with the same name) already exists in the system,
     * @param args a list of Strings with length 3, representing user arguments to the New command
     * @return a String indicating a new task has been added successfully
     */
    @Override
    public String execute(String[] args) throws Exception {
        TodoSystem todoSystem = this.dataAccessor.getTodoSystem(); // Get access to entities
        try {
            checkArgs(todoSystem, args); // Check whether arguments are valid
        } catch (Exception e) {
            return "Task added unsuccessfully due to invalid arguments.";
        }

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
        // TODO: create InvalidArgumentException
        if (args.length != 3) {
            throw new Exception("Wrong argument length!");
        } else if (todoSystem.getTasks().containsKey(args[0])) {
            throw new Exception("Task (with the same name) already existed. " +
                    "We do not support duplicate tasks (for now).");
        } // TODO: check whether due date is valid
    }
}
