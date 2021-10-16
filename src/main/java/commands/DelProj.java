package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;

public class DelProj implements Executable {
    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        // Map user arguments to project name
        String name = args[0];
        // Move tasks inside this project to Inbox and delete this project
        Project project = todoSystem.getProjects().get(name);
        Project inbox = todoSystem.getProjects().get("Inbox");
        inbox.getTasks().putAll(project.getTasks());
        todoSystem.delProj(name);

        return "Project <" + name + "> has been removed and all tasks have been added into inbox successfully.";
    }
}