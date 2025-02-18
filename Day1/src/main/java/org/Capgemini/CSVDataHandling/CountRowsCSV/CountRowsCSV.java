package org.Capgemini.CSVDataHandling.CountRowsCSV;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountRowsCSV {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/CountRowsCSV/read.csv";

        // Initialize a counter variable to count the rows (excluding the header)
        int rowsCount = 0;

        // Try-with-resources to ensure BufferedReader is automatically closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Declare a variable to hold each line from the CSV file
            String line = null;

            // Skip the header row of the CSV file (first row)
            br.readLine(); // This skips the first line which is the header

            // Read each line of the file and count the number of rows
            while ((line = br.readLine()) != null) {
                // Increment the row count for each line of data
                rowsCount++;
            }

            // Print the total number of rows (excluding the header row)
            System.out.println(rowsCount);
        } catch (Exception e) {
            // If an exception occurs (e.g., file not found), print the stack trace for debugging
            e.printStackTrace();
        }
    }
}
