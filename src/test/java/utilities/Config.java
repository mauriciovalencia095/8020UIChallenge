package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static Properties configFile;

    static {
        try {
            configFile = new Properties();
            FileInputStream conFile = new FileInputStream("./config.properties");
            configFile.load(conFile);
            conFile.close();
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return configFile.getProperty(key);
    }
}