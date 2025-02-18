package org.Capgemini.CSVDataHandling.DetectDuplicates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/DetectDuplicates/duplicates.csv";
        Set<String> seenIds = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0].trim(); // Assuming ID is in the first column

                // Check for duplicates
                if (!seenIds.add(id)) {
                    duplicates.add(line); // If ID is already seen, it's a duplicate
                }
            }

            // Print duplicate records
            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String duplicate : duplicates) {
                    System.out.println(duplicate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

