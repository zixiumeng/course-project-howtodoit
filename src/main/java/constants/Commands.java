package constants;

import commands.Executable;
import commands.NewTask;
import commands.Reproj;

import java.util.HashMap;

public class Commands {
    public static final HashMap<String, Executable> COMMANDS = new HashMap<>();

    /**
     * This class loads all commands.
     */
    public static void loadCommands() {
        COMMANDS.put("newtask", new NewTask());
        COMMANDS.put("rename", new NewTask());
        COMMANDS.put("reproj", new Reproj());
        // TODO: add more commands and create those classes!


    }
}
