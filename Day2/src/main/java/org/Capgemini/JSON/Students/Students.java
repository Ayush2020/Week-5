package org.Capgemini.JSON.Students;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Students {

    public static void main(String[] args) throws Exception {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Create a JSON Object (ObjectNode) for the student
        ObjectNode studentJson = objectMapper.createObjectNode();

        // Add fields to the JSON Object
        studentJson.put("name", "John Doe");
        studentJson.put("age", 21);

        // Create a JSON Array (ArrayNode) for subjects
        ArrayNode subjectsArray = objectMapper.createArrayNode();
        subjectsArray.add("Mathematics");
        subjectsArray.add("Science");
        subjectsArray.add("History");
        subjectsArray.add("English");

        // Add the subjects array to the JSON object
        studentJson.set("subjects", subjectsArray);

        // Convert the JSON object to a string
        String jsonString = objectMapper.writeValueAsString(studentJson);

        // Print the JSON string
        System.out.println(jsonString.toString());
    }
}

