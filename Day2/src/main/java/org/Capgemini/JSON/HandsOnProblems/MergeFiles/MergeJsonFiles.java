package org.Capgemini.JSON.HandsOnProblems.MergeFiles;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON files
            JsonNode json1 = objectMapper.readTree(new File("D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/HandsOnProblems/MergeFiles/file1.json"));
            JsonNode json2 = objectMapper.readTree(new File("D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/HandsOnProblems/MergeFiles/file2.json"));

            // Merge JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            // Write merged JSON to a file
            objectMapper.writeValue(new File("D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/HandsOnProblems/MergeFiles/merge.json"), mergedJson);

            System.out.println("Merged JSON file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
