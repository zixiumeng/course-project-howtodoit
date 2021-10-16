package helper;

import todoSystem.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chronological {
    public static List<Task> tasks_in_ch_order(HashMap<String, Task> map) {
        List<Task> list_to_return = new ArrayList<>();
        for (String s : map.keySet()) {
           add_task_to_list(list_to_return, map.get(s));
        }
        return list_to_return;
    }

    private static void add_task_to_list(List<Task> list, Task t) {
        for (Task item : list) {
            if (LocalDate.parse(t.getDueDate()).isBefore(LocalDate.parse(item.getDueDate()))) {
                list.add(list.indexOf(item), t);
                return;
            }
        }
        list.add(t);
    }
}

