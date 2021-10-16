package commands;

import driver.DataAccessor;
import driver.DataManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewLabTest {
    DataAccessor dataAccessor;
    NewLab newlabCommand = new NewLab();

    @Before
    public void setUp() {
        this.dataAccessor = new DataManager();
    }

    @Test
    public void testSuccesslyAddedLabel() {
        try {
            String[] args = {"CS"};
            this.newlabCommand.execute(this.dataAccessor, args);
            // Check that the system has this label
            assertTrue(this.dataAccessor.getSystem().getLabels().containsKey("CS"),
                    "Failure: label has not been added successfully");
        } catch (Exception e) {
            fail("Failure: an unexpected Exception was thrown.");
        }
    }

}