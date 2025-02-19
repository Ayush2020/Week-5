package org.Capgemini.JSON.HandsOnProblems.ParseJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ParseJSON {
    public static void main(String[] args) {
        try {
            // JSON input as a string
            String jsonArray = "[{\"name\":\"Ayush\",\"age\":21},"
                    + "{\"name\":\"Rahul\",\"age\":26},"
                    + "{\"name\":\"Priya\",\"age\":30},"
                    + "{\"name\":\"Vikas\",\"age\":24}]";

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON array into JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonArray);

            // Create a new ArrayNode to store filtered results
            ArrayNode filteredArray = objectMapper.createArrayNode();

            // Iterate through JSON array and filter records where age > 25
            for (JsonNode node : rootNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredArray.add(node);  // Add matching records to filteredArray
                }
            }

            // Convert filtered JSON back to string and print
            String filteredJson = objectMapper.writeValueAsString(filteredArray);
            System.out.println(filteredJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
