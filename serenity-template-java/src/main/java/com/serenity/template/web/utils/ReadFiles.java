package com.serenity.template.web.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.SystemUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.LoggerFactory;
import net.thucydides.model.environment.SystemEnvironmentVariables;


public class ReadFiles {
    private static final String PROPERTIES_EXTENSION = ".properties";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFiles.class);
    private static final SystemEnvironmentVariables CONF = SystemEnvironmentVariables.createEnvironmentVariables();

    public static Properties getRootPropertiesFile(String fileName) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(fileName + PROPERTIES_EXTENSION)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("Failure reading properties file " + fileName + PROPERTIES_EXTENSION, e);
        }
        return properties;
    }

    public static Properties getPropertiesFile(String fileName) {
        Properties properties = new Properties();
        try {
            properties.load(ReadFiles.class.getResourceAsStream("/properties/" + fileName + PROPERTIES_EXTENSION));
        } catch (IOException e) {
            LOGGER.error("Failure reading properties file " + fileName + PROPERTIES_EXTENSION, e);
        }
        return properties;
    }

    public static String getConfig(String key) {
        String config = CONF.getProperty(key);
        if (config != null) {
            LOGGER.info("Config found! '" + key + "': " + config);
        } else {
            LOGGER.error("Config not found! '" + key + "'");
        }
        return config;
    }
}
