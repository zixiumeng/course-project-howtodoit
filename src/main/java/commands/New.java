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
    public String execute(String[] args) {
        // Get access to entities
        TodoSystem todoSystem = this.dataAccessor.getTodoSystem();
        // Map user arguments to name, dueDate, description
        String name = args[0];
        String dueDate = args[1];
        String description = args[2];
        // Get Inbox
        Project inbox = todoSystem.getProjects().get("Inbox");
        // Create a new task with name, dueDate, and description, and add it to Inbox
        Task task = new Task(name, dueDate, description, inbox);
        todoSystem.getTasks().put(name, task);
        todoSystem.getProjects().get("Inbox").addTask(task);

        return "Task added successfully.";
    }
}
