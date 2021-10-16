package todoSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import helper.chronological;
/**
 * This class stores a collection of tasks.
 */
public class Folder implements Serializable {
    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();
    private boolean renameable;

    public Folder(String name, boolean renameable) {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.put(task.getName(), task);
    }

    public void delTask(Task task) {
        this.tasks.remove(task.getName());
    }

    public List<Task> viewTasks() {
        return chronological.task_in_ch_order(this.tasks);
    }
}
