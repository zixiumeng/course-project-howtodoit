package todoSystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class stores a collection of tasks.
 * TODO: use iterater design pattern
 */
public class Folder implements Serializable {
    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();
    private boolean renameable;

    public Folder(String name, boolean renameable) {
    }

    public void addTask(Task task) {
        this.tasks.put(task.getName(), task);
    }

    public String getName() {
        return this.name;
    }

    public int getNumTasks() {
        return this.tasks.size();
    }

    public List<Task> viewTasks() {
        return new ArrayList<Task>(tasks.values());
    }
}
