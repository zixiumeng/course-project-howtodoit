package todoSystem;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<Task> list_to_return = new ArrayList<>();
        for (String s : this.tasks.keySet()) {
            if (list_to_return.isEmpty()) {
                list_to_return.add(this.tasks.get(s));
            } else {
                add_task(this.tasks.get(s), list_to_return);
            }
        }
        return list_to_return;
    }

    public boolean add_task(Task t, List<Task> list) {
        for (Task item : list) {
            if (LocalDate.parse(t.getDueDate()).isBefore(LocalDate.parse(item.getDueDate()))) {
                list.add(list.indexOf(item), t);
                return true;
            }
        }
        return false;

    }
}
