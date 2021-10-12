package driver;

import todoSystem.TodoSystem;

/**
 * This interface provides access to our main entity TodoSystem.
 */
public interface DataAccessor {
    TodoSystem getTodoSystem();
}
