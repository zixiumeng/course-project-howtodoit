package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;
import todoSystem.Label;
import todoSystem.Task;

public class TaskLabAdd implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and label name
        String taskName = args[0];
        String labName = args[1];
        // Add task to label
        Task task = todoSystem.getTasks().get(taskName);
        Label label = todoSystem.getLabels().get(labName);
        label.addTask(task);

        return "Task <" + taskName + "> has been added to label <" + labName + "> successfully.";
    }
}