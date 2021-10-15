package commands;

import driver.DataAccessor;

public interface Executable {
    String execute(DataAccessor dataAccessor, String[] args) throws Exception;
}
