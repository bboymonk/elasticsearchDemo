package com.wjb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wjb on 2017/6/23.
 */
public class ConfigManager {
    private static ConfigManager configManager;
    private static Properties properties;

    private ConfigManager(){
        String file = "wjb.properties";
        properties = new Properties();
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(file);
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static ConfigManager getInstance(){
        if (configManager == null){
            configManager = new ConfigManager();
        }
        return configManager;
    }

    public String getString(String key){
        return properties.getProperty(key);
    }

}
