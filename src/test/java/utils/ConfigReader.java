// Package where the utility classes are stored
package utils;

// Used to read data from a file
import java.io.FileInputStream;

// Used to handle file reading exceptions
import java.io.IOException;

// Java class used to store key-value pairs
import java.util.Properties;

// Utility class used to read values from config.properties
public class ConfigReader {

    // Properties object stores all key-value pairs from the file
    private Properties properties;

    // Constructor
    // This runs automatically whenever an object of ConfigReader is created
    public ConfigReader() {

        // Create a Properties object
        properties = new Properties();

        try {

            // Open the config.properties file
            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            // Load all key-value pairs into the Properties object
            properties.load(file);

        } catch (IOException e) {

            // Print the error if the file is missing or cannot be read
            e.printStackTrace();

        }

    }

    // Method to return the value for a given key
    public String getProperty(String key) {

        // Example:
        // key = "baseUrl"
        // returns "https://www.amazon.in"
        return properties.getProperty(key);

    }

}
