package commands;

import driver.DataAccessor;

public interface Executable {
    String execute(String[] args) throws Exception;
}
