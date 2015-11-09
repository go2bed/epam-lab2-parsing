package com.epam.chadov.task2.io;

import com.epam.chadov.task2.exceptions.PropertyManagerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class contains resources for work with parameters from property file
 * And name of property file
 */
public class PropertyMgr {
    private static final Logger logger = LogManager.getLogger(PropertyMgr.class.toString());
    private static final String PROPERTIES_FILE = "app.properties";
    public static PropertyMgr instance = null;
    private  Properties properties = new Properties();

    private PropertyMgr() {
    }

    /**
     * Creation instance of Property manager, calling method of loadFile
     * @return
     * @throws PropertyManagerException
     * @throws IOException
     */
    public static PropertyMgr getInstance() throws PropertyManagerException, IOException {
        if(instance == null) {
            instance = new PropertyMgr();
            try {
                instance.loadProperties();
            } catch (IOException e) {
                logger.error("Could'nt load properies from file app.properties");
               throw new PropertyManagerException("Could'nt load properies from file app.properties", e);
            }
        }
        return (instance);
    }

    public String getProperty(String key) {
        logger.trace("get key from property file");
         return properties.getProperty(key);
    }

    /**
     * Method loading data from property file
     * @throws IOException
     * @throws PropertyManagerException
     */
    private void loadProperties() throws IOException, PropertyManagerException {
        InputStream in = PropertyMgr.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
        try {
            properties.load(in);
        } catch (IOException e) {
            logger.error("Could'nt load properies from file app.properties");
            throw new PropertyManagerException("Could'nt load properies from file app.properties", e);
        }
        in.close();
    }
}
