package commands;

import driver.DataAccessor;
import todoSystem.Label;
import todoSystem.TodoSystem;

public class DelTaskLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to task name and label name
        String taskName = args[0];
        String labName = args[1];
        // Remove task from label
        Label label = todoSystem.getLabels().get(labName);
        label.delTask(taskName);

        return "Task <" + taskName + "> has been removed from label <" + labName + "> successfully.";
    }
} 