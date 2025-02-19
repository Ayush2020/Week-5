package org.Capgemini.JSON.HandsOnProblems.JSONToXML;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;

public class JsonToXml {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file into a String
            File jsonFile = new File("D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/HandsOnProblems/JSONToXML/data.json");
            JSONObject jsonObject = new JSONObject(objectMapper.readTree(jsonFile).toString());

            // Convert JSON to XML
            String xmlData = XML.toString(jsonObject, "root"); // "root" is the root element

            // Print XML output
            System.out.println(xmlData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
