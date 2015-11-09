package com.epam.chadov.task2.io;

import com.epam.chadov.task2.exceptions.PropertyManagerException;
import com.epam.chadov.task2.exceptions.ReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *Class contains method for extracting information
 * from file in root directory
 */
public class FileUtils implements FileUtil {
     private static final Logger logger = LogManager.getLogger(FileUtils.class.toString());
     public final String PATH_FILE = "path.file";
     public final String ENCODING = "encoding";

    public String readAllBytes() throws ReadingException, IOException, PropertyManagerException {

       PropertyMgr propertyMgr = PropertyMgr.getInstance();

        try {
            String stringText = new String(Files.readAllBytes
                    (Paths.get(propertyMgr.getProperty(PATH_FILE))),propertyMgr.getProperty(ENCODING)
            );
            return stringText;
        } catch (IOException e) {
            logger.error("Error reading file - check file, please");
            throw new ReadingException("Error reading file.", e);
        }
    }
}
