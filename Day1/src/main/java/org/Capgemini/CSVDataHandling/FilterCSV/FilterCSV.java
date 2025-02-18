package org.Capgemini.CSVDataHandling.FilterCSV;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/FilterCSV/filter.csv";

        // Try-with-resources to ensure BufferedReader is automatically closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and skip the header line (the first row in the CSV file)
            br.readLine();  // Skips the header row

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                // Split the line into columns (values) by comma
                String[] columns = line.split(",");

                // Parse the marks (assuming marks are in the 4th column, index 3)
                // Note: The "+ " is invalid here, the trim() method should be used alone to remove extra spaces
                int marks = Integer.parseInt(columns[3].trim());

                // Check if the student's marks are greater than 80
                if (marks > 80) {
                    // Print out the details of students with marks greater than 80
                    System.out.print(columns[0] + " ");  // Print student ID
                    System.out.print(columns[1] + " ");  // Print student name
                    System.out.print(columns[2] + " ");  // Print student age
                    System.out.print(columns[3] + " ");  // Print student marks
                    System.out.println();  // Print a new line after each student's record
                }
            }
        } catch (IOException e) {
            // If there is an error reading the file, print the stack trace for debugging
            e.printStackTrace();
        }
    }
}

