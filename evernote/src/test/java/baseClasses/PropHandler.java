package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropHandler {
    Properties prop = new Properties();
    InputStream input = null;
    File propertyFile = null;
    public void setPropertyFile(String location) {
        try {
            propertyFile = new File(location);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getValue(String key) throws IOException {
        String value = "";
        try {
            input = new FileInputStream(propertyFile);
            prop.load(input);
            value = prop.getProperty(key);
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return value;
    }
}