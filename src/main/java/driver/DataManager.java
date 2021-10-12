package driver;

import todoSystem.TodoSystem;

/**
 * This class reads data from and writes data into local files.
 */
public class DataManager implements DataAccessor {
    private final TodoSystem todoSystem = new TodoSystem();

    /**
     * This function reads data from local files and mutates todoSystem.
     */
    public void readData() {

    }

    /**
     * This function writes data into local files using todoSystem.
     */
    public void writeData() {

    }

    /**
     * the
     * @return todoSystem
     */
    public TodoSystem getTodoSystem() {
        return this.todoSystem;
    }
}
