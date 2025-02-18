package org.Capgemini.CSVDataHandling.WriteCSV;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        // Define the file path where the CSV file will be created
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/WriteCSV/output.csv";


        // Use try-with-resources to automatically close the BufferedWriter after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Write the header row (column names) to the CSV file
            writer.write("ID, Name, Department, Salary\n");

            // Write the data rows to the CSV file
            writer.write("104,Gautam ,Finance,62000\n");
            writer.write("105,HeMan,Sales,58000\n");

            // Print a success message after writing the file
            System.out.println("CSV File written successfully!!");
        } catch (IOException e) {
            // Catch and print any I/O exceptions that occur during file writing
            e.printStackTrace();
        }
    }
}
