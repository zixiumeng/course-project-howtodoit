package todoSystem;

import java.io.Serializable;
import java.util.HashMap;
/**
 * This class stores a collection of tasks.
 */
public class Folder implements Serializable {
    private String name;
    private final HashMap<String, Task> tasks = new HashMap<>();

    public Folder(String name) {
        this.name = name;
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

    public void delTask(String name) {
        this.tasks.remove(name);
    }
}
