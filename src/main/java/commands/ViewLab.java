package commands;

import driver.DataAccessor;
import todoSystem.Label;
import todoSystem.TodoSystem;
import todoSystem.Task;

import java.util.ArrayList;
import java.util.List;
import helpers.ChronologicalSort;

import java.util.HashMap;

public class ViewLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        Label lab = todoSystem.getLabels().get(args[0]);
        HashMap<String, Task> tasks = lab.getTasks();
        List<Task> viewable = ChronologicalSort.tasks_in_ch_order(tasks);
        ArrayList<String> namelist = new ArrayList<>();

        for (Task task : viewable) {
            namelist.add(task.getName());
        }

        String f = namelist.toString();
        return "This label " + args[0] + " contains the following tasks: <" + f + ">.";


    }
}