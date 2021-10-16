package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;
import todoSystem.Task;

import java.util.ArrayList;
import java.util.List;
import helpers.ChronologicalSort;

import java.util.HashMap;

public class ViewProj implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        Project project = todoSystem.getProjects().get(args[0]);
        HashMap<String, Task> tasks = project.getTasks();
        List<Task> viewable = ChronologicalSort.tasks_in_ch_order(tasks);
        ArrayList<String> namelist = new ArrayList<>();

        for (Task task : viewable) {
            namelist.add(task.getName());
        }

        String f = namelist.toString();
        return "This project " + args[0] + " contains the following tasks: <" + f + ">.";


    }
}
