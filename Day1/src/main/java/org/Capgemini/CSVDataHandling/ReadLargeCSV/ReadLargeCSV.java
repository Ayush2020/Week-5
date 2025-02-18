package org.Capgemini.CSVDataHandling.ReadLargeCSV;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {

    public static void main(String[] args) {
        // File path for the large CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/ReadLargeCSV/large.csv";

        // Number of lines to read at a time (chunk size)
        int chunkSize = 100;

        int totalProcessedRecords = 0;  // To keep track of the total processed records

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLineCount = 0;

            // Skip the header row (optional)
            br.readLine();

            // Read the file in chunks
            while ((line = br.readLine()) != null) {
                currentLineCount++;

                // Process the current line (for demonstration, print it out)
                System.out.println(line);

                // If 100 lines are processed, display count and reset counter
                if (currentLineCount == chunkSize) {
                    totalProcessedRecords += chunkSize;
                    System.out.println("Processed " + totalProcessedRecords + " records so far.");
                    currentLineCount = 0;  // Reset the counter for the next chunk
                }
            }

            // If any remaining lines are left to be processed (less than 100)
            if (currentLineCount > 0) {
                totalProcessedRecords += currentLineCount;
                System.out.println("Processed " + totalProcessedRecords + " records in total.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
