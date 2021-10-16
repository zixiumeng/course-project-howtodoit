package todoSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class stores all system objects such as tasks, projects, and labels.
 */
public class TodoSystem implements Serializable {
    private final HashMap<String, Task> tasks = new HashMap<>();
    private final HashMap<String, Project> projects = new HashMap<>();
    private final HashMap<String, Label> labels = new HashMap<>();

    public TodoSystem() {
        projects.put("Inbox", new Project("Inbox"));
        labels.put("Starred", new Label("Starred"));
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
        Task task = this.tasks.get(name);
        task.getProject().delTask(name); // Delete task from its project
        // Delete task from all the labels it's in
        ArrayList<Label> labels = task.getLabels();
        for (Label label : labels) {
            label.delTask(name);
        }
        this.tasks.remove(name); // Delete task from the system
    }

    public void addProj(String name) {
        this.projects.put(name, new Project(name));
    }

    public void delProj(String name) {
        Project project = this.projects.get(name);
        Project inbox = this.projects.get("Inbox");
        inbox.getTasks().putAll(project.getTasks()); // Move all tasks in this project to Inbox
        this.projects.remove(name);
    }

    public void addLab(String name) {
        this.labels.put(name, new Label(name));
    }

    public void delLab(String name) {
        Label label = this.labels.get(name);
        // Remove this label from all tasks it contains
        for (String taskName : label.getTasks().keySet()) {
            Task task = this.tasks.get(taskName);
            task.getLabels().remove(label);
        }
        this.labels.remove(name);
    }
}
