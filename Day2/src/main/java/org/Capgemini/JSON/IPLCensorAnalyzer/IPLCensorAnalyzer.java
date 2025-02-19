package org.Capgemini.JSON.IPLCensorAnalyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        // Define file paths
        String jsonInputFile = "D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/IPLCensorAnalyzer/ipldata.json";
        String jsonOutputFile = "D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/IPLCensorAnalyzer/iplcensored.json";
        String csvInputFile = "D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/IPLCensorAnalyzer/ipldata.csv";
        String csvOutputFile = "D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/IPLCensorAnalyzer/iplcensored.csv";

        // Process JSON Data
        processJsonData(jsonInputFile, jsonOutputFile);

        // Process CSV Data
        processCsvData(csvInputFile, csvOutputFile);
    }

    // Method to process JSON data
    public static void processJsonData(String inputFile, String outputFile) {
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(inputFile));

            // Create a new array to store sanitized data
            ArrayNode sanitizedArray = objectMapper.createArrayNode();

            for (JsonNode node : rootNode) {
                ObjectNode modifiedNode = (ObjectNode) node;

                // Apply censorship rules
                modifiedNode.put("team1", maskTeamName(node.get("team1").asText()));
                modifiedNode.put("team2", maskTeamName(node.get("team2").asText()));
                modifiedNode.put("winner", maskTeamName(node.get("winner").asText()));
                modifiedNode.put("player_of_match", "REDACTED");

                // Update the score keys
                ObjectNode updatedScore = objectMapper.createObjectNode();
                node.get("score").fields().forEachRemaining(entry -> {
                    updatedScore.put(maskTeamName(entry.getKey()), entry.getValue().asInt());
                });
                modifiedNode.set("score", updatedScore);

                sanitizedArray.add(modifiedNode);
            }

            // Write sanitized data to a new JSON file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), sanitizedArray);
            System.out.println(" Censored JSON data written to " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to process CSV data
    public static void processCsvData(String inputFile, String outputFile) {
        try {
            // Read CSV file
            List<String> lines = Files.readAllLines(Paths.get(inputFile));
            if (lines.isEmpty()) return;

            // Process header and data rows
            String header = lines.get(0); // First line is the header
            List<String> modifiedLines = lines.stream().skip(1).map(line -> {
                String[] values = line.split(",");
                values[1] = maskTeamName(values[1]);  // team1
                values[2] = maskTeamName(values[2]);  // team2
                values[5] = maskTeamName(values[5]);  // winner
                values[6] = "REDACTED";  // player_of_match
                return String.join(",", values);
            }).collect(Collectors.toList());

            // Write to new CSV file
            Files.write(Paths.get(outputFile), Arrays.asList(header));
            Files.write(Paths.get(outputFile), modifiedLines, java.nio.file.StandardOpenOption.APPEND);
            System.out.println("Censored CSV data written to " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to mask team names
    private static String maskTeamName(String teamName) {
        if (teamName.contains(" ")) {
            String[] words = teamName.split(" ");
            return words[0] + " ***";
        }
        return teamName; // If only one word, return as is
    }
}
