package com.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class LocalPropertiesLoaderUtils{
    /**
     * Name of the class path resource (relative to the ContextLoader class)
     * that defines ContextLoader's default strategy names.
     */
    private static final String DEFAULT_PROPERITS_PATH = "test.properties";


    private static final Properties defaultStrategies;

    public static String speed;

    static {
        // Load default strategy implementations from properties file.
        // This is currently strictly internal and not meant to be customized
        // by application developers.
        try {
//            ClassPathResource resource = new ClassPathResource(DEFAULT_PROPERITS_PATH, ContextLoader.class);
            defaultStrategies = PropertiesLoaderUtils.loadAllProperties(DEFAULT_PROPERITS_PATH);
            speed = defaultStrategies.getProperty("speed");
        }
        catch (IOException ex) {
            throw new IllegalStateException("Could not load 'ContextLoader.properties': " + ex.getMessage());
        }
    }

    /*public static void main(String[] args){
        System.out.println(LocalPropertiesLoaderUtils.speed);
    }*/
}