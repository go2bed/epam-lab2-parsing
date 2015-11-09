package com.epam.chadov.task2.io;

import com.epam.chadov.task2.exceptions.PropertyManagerException;
import com.epam.chadov.task2.exceptions.ReadingException;

import java.io.IOException;

public interface FileUtil {

    String readAllBytes() throws ReadingException, IOException, PropertyManagerException;

}
