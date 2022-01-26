package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    String propertyFilePath = "src/main/resources/config.properties";
    public ConfigFileReader() {
        BufferedReader reader;
        try {
                reader = new BufferedReader(new FileReader(propertyFilePath));
                properties = new Properties();
                try {
                    properties.load(reader);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at ");
        }
    }
    public String getAmazonPhoneNumber() {
        String amazon_phone = properties.getProperty("phone");
        if(amazon_phone != null) return amazon_phone;
        else throw new RuntimeException("amazon_phone not specified in the Configuration.properties file.");
    }
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getAmazonPassword() {
        String amazon_password = properties.getProperty("password");
        if(amazon_password != null) return amazon_password;
        else throw new RuntimeException("amazon_password not specified in the Configuration.properties file.");
    }
    public String getSearchedText() {
        String searchText = properties.getProperty("searchText");
        if(searchText != null) return searchText;
        else throw new RuntimeException("searchText not specified in the Configuration.properties file.");
    }
}
