package com.epam.chadov.task2.task;

import com.epam.chadov.task2.entity.Text;
import com.epam.chadov.task2.exceptions.TaskException;

public interface TaskInterface {
    void execute(Text text) throws TaskException;
}
