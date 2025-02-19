package org.Capgemini.JSON.HandsOnProblems.JSONSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class EmailValidation {
    public static void main(String[] args) {
        try {
            // JSON Schema defining the "email" field validation
            String schemaString = "{"
                    + "\"type\": \"object\","
                    + "\"properties\": {"
                    + "  \"email\": {"
                    + "    \"type\": \"string\","
                    + "    \"format\": \"email\""
                    + "  }"
                    + "},"
                    + "\"required\": [\"email\"]"
                    + "}";

            // Sample JSON Data to Validate
            String jsonData = "{ \"email\": \"test@example.com\" }"; // Valid email

            // Convert Strings to JSON Objects
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);
            JSONObject jsonSchema = new JSONObject(schemaString);
            JSONObject jsonObject = new JSONObject(jsonNode.toString());

            // Load and Validate JSON
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonObject); // No exception means validation passed

            System.out.println(" Valid Email!");

        } catch (Exception e) {
            System.out.println(" Invalid Email: " + e.getMessage());
        }
    }
}
