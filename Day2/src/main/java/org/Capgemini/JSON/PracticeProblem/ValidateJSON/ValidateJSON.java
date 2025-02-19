package org.Capgemini.JSON.PracticeProblem.ValidateJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJSON {
    public static boolean isValidJsonStructure(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // Check required fields
            return jsonNode.has("name") && jsonNode.has("age") && jsonNode.get("age").isInt();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String validJson = "{ \"name\": \"Ayush\", \"age\": 21 }";
        String invalidJson = "{ \"name\": \"Ayush\" }";

        System.out.println("Valid JSON: " + isValidJsonStructure(validJson));  // true
        System.out.println("Invalid JSON: " + isValidJsonStructure(invalidJson));  // false
    }
}
