package gamecreator.framework;

//import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ConfigurationException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Loader {
    private static final String propPath =System.getProperty("user.dir")+"/Game.properties";   //System.getProperty("user.dir")+ getClass().getResourceAsStream
    private static Properties proper = new Properties();
    private static File propFile = new File(propPath);
    static FileWriter fileWriter = null;
    private static PropertiesConfiguration config;

    public static String loadProperty(String name) {

        try {
            proper.load(new FileInputStream(propFile));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog (null, "Can't find property file!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String value = "";
        if (name != null) {
            value = proper.getProperty(name);
        }
        return value;
    }

    //add new properties to file
    public static void updateProperty(String propName, String propValue) {
        OutputStream output = null;
        try {
            output = new FileOutputStream(propFile);
            proper.setProperty(propName, propValue);
            proper.store(output, null);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog (null, "Property file was not updated!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
