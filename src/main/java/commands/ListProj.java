package commands;

import driver.DataAccessor;
import todoSystem.Project;
import todoSystem.TodoSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListProj implements Executable {

    @Override
    public String execute(DataAccessor dataAccessor, String[] args) {
        TodoSystem todoSystem = dataAccessor.getSystem(); // Get access to entities
        // checkArgs(todoSystem, args); // Check whether arguments are valid

        HashMap<String, Project> projects = todoSystem.getProjects();
        Set<String> nameSet = projects.keySet();
        List<String> f = nameSet.stream().sorted().collect(Collectors.toList());

        f.remove("Inbox");
        f.add(0, "Inbox");

        return "The following projects are in howtodoit now: " + f + ".";


    }
}
