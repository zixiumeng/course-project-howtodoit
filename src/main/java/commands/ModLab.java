package commands;

import driver.DataAccessor;
import todoSystem.Label;
import todoSystem.TodoSystem;

/**
 * This class renames a label.
 */
public class ModLab implements Executable{
    /**
     * This function executes the modlab command: change a label’s name from <name1> to <name2>
     * The label must already exist in the system.
     *
     * @param args a String, representing user arguments
     * @return a String indicating a label name has been changed
     */
    @Override
    public String execute(DataAccessor dataAccessor, String[] args){
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, name); // Check whether argument are valid

        // Map user arguments to old name, new name
        String name1 = args[0];
        String name2 = args[1];
        // Get label and rename it
        Label label = todoSystem.getLabels().get(name1);
        label.setName(name2);

        return "Label <" + name1 + "> has been renamed to <" + name2 + "> successfully.";
    }
}