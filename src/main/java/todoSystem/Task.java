package todoSystem;

public class Task {
    private String name;
    private String dueDate;
    private String description;
    private Project project;

    public Task(String name, String dueDate, String description, Project project) {
        this.name = name;
        this.dueDate = dueDate;
        this.description = description;
        this.project = project;
    }

    public String getName() {
        return this.name;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String getDescription() {
        return this.description;
    }

    public Project getProject() {
        return project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
