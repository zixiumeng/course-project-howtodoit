package commands;

import driver.DataAccessor;
import todoSystem.Task;
import todoSystem.TodoSystem;
import helper.chronological;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Upcoming implements Executable {

    /**
     * This function executes the Upcoming command: List the tasks in chronological order
     *
     * @param args a list of Strings with length 1, representing the completed task
     * @return a String indicating the completed task has been deleted.
     */

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem();
        HashMap<String, Task> map = todoSystem.getTasks();
        List<Task> list = chronological.task_in_ch_order(map);
        for (Task t: list) {
            System.out.println(t.toString() + '\n');
        }
        return "Tasks are printed in chronological order";
    }
}
