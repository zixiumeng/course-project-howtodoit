package todoSystem;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class stores all system objects such as tasks, projects, and labels.
 */
public class TodoSystem implements Serializable {
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

    public void addTask(String name, String duedate, String description, Project project) {
        Task task = new Task(name, duedate, description, project);
        this.tasks.put(name, task);
        project.addTask(task);
    }

    public void delTask(String name) {
        this.tasks.remove(name);
    }

    public void addProj(String name) {
        this.projects.put(name, new Project(name, true));
    }

    public void delProj(String name) {
        this.projects.remove(name);
    }

    public void addLab(String name) {
        this.labels.put(name, new Label(name, true));
    }

    public void delLab(String name) {
        this.labels.remove(name);
    }
}
