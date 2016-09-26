package ru.k66.myweb.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyGet {


    public Properties getProperties(String fileName) {

        Properties properties = new Properties();
        //marker
        boolean isXMLSuccess;

        //for XML
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            properties.loadFromXML(fileInputStream);
            isXMLSuccess = true;

        } catch (IOException e) {
            isXMLSuccess = false;
        }

        //non XML
        if (!isXMLSuccess) {
            FileInputStream fileInputStream;

            try {
                fileInputStream = new FileInputStream(fileName);
                properties.load(fileInputStream);
                fileInputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }
}