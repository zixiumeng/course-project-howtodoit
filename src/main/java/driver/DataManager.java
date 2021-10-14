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
     * the file should be name, dueday, description and project.
     * TODO: we can only store a project using string?
     */
    public void readData(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String s;
        while ((s=br.readLine())!= null){
            String[] sl = s.split("");
            if (todoSystem.getProjects().containsKey(sl[3])) {
                Project pro = todoSystem.getProjects().get(sl[3]);
                Task t = new Task(sl[0], sl[1], sl[2], pro);
                pro.addTask(t);
            }
            else {
                /* TODO: let the renamebable be true, may change after

                 */
                Project new_pro = new Project(sl[3], true);
                todoSystem.getProjects().put(sl[3], new_pro);
                Task t = new Task(sl[0], sl[1], sl[2], new_pro);
                new_pro.addTask(t);
            }
        }
    }

    /**
     * This function add task to the given file
     */
    public void writeData(File file) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        for (Task task : this.todoSystem.getTasks().values()) {
            String s = task.getName() + " " +
                    task.getDueDate() + " " + task.getDescription() + " " + task.getProject().getprojectname();
            pw.append(s).append("\n");
        }
        pw.close();
    }
        /**
         * the
         * @return todoSystem
         */
        public TodoSystem getTodoSystem() {
            return this.todoSystem;
        }
    }
