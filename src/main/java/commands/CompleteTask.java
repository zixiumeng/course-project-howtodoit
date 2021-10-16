package commands;

import driver.DataAccessor;
import todoSystem.TodoSystem;

public class CompleteTask implements Executable {

    /**
     * This function executes the completeTask command: Delete the task thtat already finished
     * The task must already exist in the system.
     *
     * @param args a list of Strings with length 1, representing the completed task
     * @return a String indicating the completed task has been deleted.
     */

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) throws Exception {
        TodoSystem todoSystem = dataAccessor.getSystem();
        todoSystem.getTasks().remove(args[0]);
        return "Tasks have been deleted.";
    }
}