package org.Capgemini.CSVDataHandling.ReadCSV;

import java.util.*;
import java.io.*;

public class ReadCSV {
    public static void main(String[] args) {

        // Define the path to the CSV file
        String filepath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/ReadCSV/employee.csv";

        // Try-with-resources ensures BufferedReader is closed after use
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            // Declare a variable to store each line read from the CSV file
            String line;

            // Read each line of the file
            while ((line = br.readLine()) != null) {

                // Split the line into an array of columns based on comma delimiter
                String[] columns = line.split(",");

                // Print the first column
                System.out.print(columns[0] + " ");

                // Print the second column
                System.out.print(columns[1] + " ");

                // Print the third column
                System.out.print(columns[2] + " ");

                // Print the fourth column
                System.out.print(columns[3] + " ");
                System.out.println();
            }
        } catch (IOException e) {
            // Print the exception stack trace if an error occurs during file reading
            e.printStackTrace();
        }
    }
}
