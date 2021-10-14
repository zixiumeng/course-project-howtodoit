package todoSystem;

import java.util.HashMap;

/**
 *
 */
public class TodoSystem {
    private final HashMap<String, Task> tasks = new HashMap<>();
    private final HashMap<String, Project> projects = new HashMap<>();
    private final HashMap<String, Label> labels = new HashMap<>();

    public TodoSystem() {
        projects.put("Inbox", new Project("Inbox", false));
        labels.put("Starred", new Label("Starred", false));
    }

    public HashMap<String, Task> getTasks() {
        return this.tasks;
    }

    public HashMap<String, Project> getProjects() {
        return this.projects;
    }

    public HashMap<String, Label> getLabels() {
        return this.labels;
    }
}
