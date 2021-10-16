package commands;

import driver.DataAccessor;
import driver.DataManager;

import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.*;

class NewProjTest {
    DataAccessor dataAccessor;
    NewProj newprojCommand = new NewProj();

    @Before
    public void setUp() {
        this.dataAccessor = new DataManager();
    }

    @Test
    public void testSuccesslyAddedProject() {
        try {
            String[] args = {"CSC207"};
            this.newprojCommand.execute(this.dataAccessor, args);
            // Check that the system has this label
            assertTrue(this.dataAccessor.getSystem().getProjects().containsKey("CSC207"),
                    "Failure: Project has not been added successfully");
        } catch (Exception e) {
            fail("Failure: an unexpected Exception was thrown.");
        }


    }
}
