package constants;

import commands.NewTask;
import commands.Executable;
import driver.DataAccessor;

import java.util.HashMap;

public class Commands {
    public static final HashMap<String, Executable> COMMANDS = new HashMap<>();

    /**
     * This class loads all commands.
     * @param dataAccessor the interface that provides access to entities, essential to use cases (commands)
     */
    public static void loadCommands(DataAccessor dataAccessor) {
        COMMANDS.put("newtask", new NewTask(dataAccessor));
        // TODO: add more commands and create those classes!

    }
}
