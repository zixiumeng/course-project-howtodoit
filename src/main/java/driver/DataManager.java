package driver;

import todoSystem.TodoSystem;

import java.io.*;

import static constants.FilePaths.systemFilePath;

/**
 * This class reads data from and writes data into local files.
 */
public class DataManager implements DataAccessor {
    private TodoSystem todoSystem;

    /**
     * This function reads data from local files and initializes todoSystem.
     */
    public void readData() {
        try {
            FileInputStream fileIn = new FileInputStream(systemFilePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.todoSystem = (TodoSystem) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data has been loaded successfully.");
        } catch (IOException i) {
            System.out.println("Local data not found. We are creating a new empty system.");
            this.todoSystem = new TodoSystem();
        } catch (ClassNotFoundException c) {
            System.out.println("TodoSystem class not found. We are creating a new empty system.");
            this.todoSystem = new TodoSystem();
        }
    }

    /**
     * This function writes data (tasks, projects...) into the given file.
     */
    public void writeData(){
        try {
            FileOutputStream fileOut = new FileOutputStream(systemFilePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.todoSystem);
            out.close();
            fileOut.close();
            System.out.println("Data has been saved successfully.");
        } catch (IOException i) {
            i.printStackTrace();
        }
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
