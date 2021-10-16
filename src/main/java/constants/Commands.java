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
        COMMANDS.put("completetask", new CompleteTask());
        COMMANDS.put("rename", new Rename());
        COMMANDS.put("retime", new Retime());
        COMMANDS.put("redesc", new Redesc());
        COMMANDS.put("reproj", new Reproj());
        COMMANDS.put("star", new Star());
        COMMANDS.put("addtasklab", new AddTaskLab());
        COMMANDS.put("deltasklab", new DelTaskLab());


        COMMANDS.put("newproj", new NewProj());
        COMMANDS.put("modproj", new ModProj());
        COMMANDS.put("delproj", new DelProj());

        COMMANDS.put("newlab", new NewLab());
        COMMANDS.put("modlab", new ModLab());
        COMMANDS.put("dellab", new DelLab());


    }
}
