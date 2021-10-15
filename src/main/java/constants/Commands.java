package constants;

import commands.*;

import java.util.HashMap;

public class Commands {
    public static final HashMap<String, Executable> COMMANDS = new HashMap<>();

    /**
     * This class loads all commands.
     */
    public static void loadCommands() {
        COMMANDS.put("newtask", new NewTask());
        COMMANDS.put("rename", new Rename());
        COMMANDS.put("reproj", new Reproj());
        COMMANDS.put("star", new StarTask());
        COMMANDS.put("rnproj", new ModProj());
        COMMANDS.put("mkproj", new NewProj());

        // TODO: add more commands and create those classes!


    }
}
