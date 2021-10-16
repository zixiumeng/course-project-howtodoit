package commands;

import driver.DataAccessor;
import driver.DataManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;

class NewTaskTest {
    DataAccessor dataAccessor;
    NewTask newTaskCommand = new NewTask();

    @Before
    public void setUp() {
        this.dataAccessor = new DataManager();
    }

    @Test
    public void testSuccesslyAddedTask() {
        try {
            String[] args = {"Phase 0"};
            this.newTaskCommand.execute(this.dataAccessor, args);
            // Check that the system has this label
            Assertions.assertTrue(this.dataAccessor.getSystem().getTasks().containsKey("Phase 0"),
                    "Failure: Task has not been added successfully");
        } catch (Exception e) {
            Assertions.fail("Failure: an unexpected Exception was thrown.");
        }


    }
}
