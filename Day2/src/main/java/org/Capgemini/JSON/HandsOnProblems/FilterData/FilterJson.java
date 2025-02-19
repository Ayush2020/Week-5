package org.Capgemini.JSON.HandsOnProblems.FilterData;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class FilterJson {
    public static void main(String[] args) {
        try {
            // Sample JSON data
            String jsonArray = "[{\"name\":\"Ayush\",\"age\":21},"
                    + "{\"name\":\"Rahul\",\"age\":26},"
                    + "{\"name\":\"Priya\",\"age\":30},"
                    + "{\"name\":\"Vikas\",\"age\":24}]";

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse JSON into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonArray);

            // Create an empty JSON array to store filtered data
            ArrayNode filteredArray = objectMapper.createArrayNode();

            // Iterate through JSON array and filter records where age > 25
            for (JsonNode node : rootNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredArray.add(node);
                }
            }

            // Print filtered JSON
            System.out.println(filteredArray.toPrettyString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
