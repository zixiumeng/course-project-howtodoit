package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 *
 */
public class NewTask implements Executable {
    private final DataAccessor dataAccessor;

    public NewTask(DataAccessor dataAccessor) {
        this.dataAccessor = dataAccessor;
    }

    /**
     * This function executes the New command: create a new task with given params and add it to Inbox.
     * If the same task (with the same name) already exists in the system,
     * The due day should be after the current time and have length of 8, in the format of YYYY-MM-DD.
     * @param args a list of Strings with length 3, representing user arguments to the New command
     * @return a String indicating a new task has been added successfully
     */
    @Override
    public String execute(String[] args) throws Exception {
        TodoSystem todoSystem = this.dataAccessor.getSystem(); // Get access to entities
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
        } else if (!(checkDue(args[1]))) {
            throw new Exception("Due day with wrong format, should be YYYY-MM-dd");
        } else if (LocalDate.parse(args[1]).isBefore(LocalDate.now())) {
            throw new Exception("This task is already overdue");
        };
            // TODO: check whether due date is valid

    }

    private boolean checkDue(String s) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //If we want the format of string to be formal, use false. Otherwise, use true.
            sd.setLenient(true);
            sd.parse(s);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
