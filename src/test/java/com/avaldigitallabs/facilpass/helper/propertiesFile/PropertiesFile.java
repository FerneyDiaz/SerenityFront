package com.avaldigitallabs.facilpass.helper.propertiesFile;

import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesFile {

    public static String valueToProcess;

    //This method load a value to the variable valueToProcess from properties file
    public void getPropertyFile(String key){
        Properties properties = new Properties();
        try {
            String projectPath = System.getProperty("user.dir");
            InputStream inputStream = new FileInputStream(projectPath + "/src/test/resources/data/staging.properties");
            properties.load(inputStream);
        }catch (IOException e){
            Logger.getLogger("Error reading data:properties file " + e.getMessage());
        }
        valueToProcess = properties.getProperty(key);
    }


    //this method return the value from json array in the variable valueToProcess by key
    public static String getValueByKey(String parentValue, String value) {
        String valueByKey = null;
        valueByKey = getStringFromJson(valueToProcess,parentValue);
        valueByKey = getStringFromJson(valueByKey,value);
        return valueByKey;
    }

    //this method return the value from json object in the variable valueToProcess by key
    public static String getValueByKey(String value){
        String valueByKey = null;
        valueByKey = getStringFromJson(valueToProcess,value);
        return valueByKey;
    }

    public static String getStringFromJson(String textToProcess, String key){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(textToProcess);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.get(key).toString();
    }
}
