package org.Capgemini.CSVDataHandling.SearchingInCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchInCSV {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/SearchingInCSV/search.csv";

        // Create a Scanner object to get user input (employee name to search for)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name for Search");

        // Read the name of the employee to search for
        String searchName = sc.nextLine().trim();  // trim() removes any leading or trailing spaces from the input

        // Try-with-resources to automatically close BufferedReader after use
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and skip the first line (header) in the CSV file
            br.readLine();

            // Flag to track if the employee is found
            boolean found = false;

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                // Split the current line into columns based on commas
                String[] columns = line.split(",");

                // Get the employee name (assuming it is in the second column, index 1)
                String name = columns[1].trim();  // trim() removes leading/trailing spaces from the name

                // If the name matches the search name, print the employee details
                if (name.equals(searchName)) {
                    System.out.println("Found");
                    // Print each column's value (Department, and Salary)
                    System.out.print(columns[2].trim() + " ");  // Department
                    System.out.print(columns[3].trim() + " ");  // Salary
                    System.out.println();

                    // Set 'found' to true and break out of the loop since the employee was found
                    found = true;
                    break;
                }
            }

            // If no matching employee was found, print "Not found"
            if (!found) {
                System.out.println("Not found");
            }
        } catch (IOException e) {
            // If there is an error while reading the file, print the exception details
            e.printStackTrace();
        } finally {
            // Close the scanner resource to prevent memory leaks
            sc.close();
        }
    }
}
