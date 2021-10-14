package todoSystem;

import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class Folder {
    private String name;
    private HashMap<String, Task> tasks;
    private boolean renameable;

    public Folder(String name, boolean renameable) {
        this.name = name;
        this.renameable = renameable;
    }

    public void addTask(Task task) {
        this.tasks.put(task.getName(), task);
    }

    public List<Task> viewTasks() {
        return null;
    }
}
