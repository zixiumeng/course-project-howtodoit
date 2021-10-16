package commands;

import driver.DataAccessor;
import todoSystem.Label;
import todoSystem.TodoSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListLab implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        HashMap<String, Label> labels = todoSystem.getLabels();
        Set<String> nameSet = labels.keySet();
        List<String> f = nameSet.stream().sorted().collect(Collectors.toList());
        f.remove("Starred");
        f.add(0, "Starred");

        return "The following labels are in howtodoit now: " + f + ".";


    }
}