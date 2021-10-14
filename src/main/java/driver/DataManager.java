package driver;

import todoSystem.Folder;
import todoSystem.Project;
import todoSystem.Task;
import todoSystem.TodoSystem;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * This class reads data from and writes data into local files.
 */
public class DataManager implements DataAccessor {
    private final TodoSystem todoSystem = new TodoSystem();

    /**
     * This function reads data from local files and mutates todoSystem.
     * The file should contain all projects and all tasks.
     * Each project should have name and the number of tasks contained.
     * Beneath each project, there should a list of tasks contained in that project (with "*" at the beginning).
     * Each file should have name, due date, and description.
     */
    public void readData(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String projLine;
        while ((projLine = br.readLine()) != null) {
            try {
                String[] projLineArray = projLine.split(" ");
                String projName = projLineArray[0];
                int numTasks = Integer.parseInt(projLineArray[1]); // Get the number of tasks stored
                boolean renameable = (projName.equals("Inbox"));
                Project proj = new Project(projName, renameable); // Create a new project
                this.todoSystem.getProjects().put(projName, proj); // Add it to TodoSystem

                // Add all the tasks contained in this project
                for (int i = 0; i < numTasks; i++) {
                    String[] taskLineArray = br.readLine().split(" ");
                    Task task = new Task(taskLineArray[1], taskLineArray[2], taskLineArray[3], proj);
                    todoSystem.getTasks().put(taskLineArray[0], task); // Add it to TodoSystem
                    proj.addTask(task); // Add it to its project
                }
            } catch (Exception e) {
                System.out.println("Your file is corrupted! Some if not all data is lost.");
            }
        }
    }

    /**
     * This function writes data (tasks, projects...) into the given file.
     */
    public void writeData(File file) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        for (Project proj : this.todoSystem.getProjects().values()) {
            String projLine = proj.getName() + " " + proj.getNumTasks();
            pw.append(projLine).append("\n"); // Write project info into the file
            List<Task> tasks = proj.viewTasks();
            // Now write all tasks contained in this project into the file
            for (Task task : tasks) {
                String taskLine = "* " + task.getName() + " " + task.getDueDate() + " " + task.getDescription();
                pw.append(taskLine).append("\n");
            }
        }
        pw.close();
    }

    /**
     * This function returns the TodoSystem (it's the one defined by the interface DataAccessor).
     * @return todoSystem
     */
    @Override
    public TodoSystem getTodoSystem() {
        return this.todoSystem;
    }
}
