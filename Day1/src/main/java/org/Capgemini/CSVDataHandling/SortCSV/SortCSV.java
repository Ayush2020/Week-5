package org.Capgemini.CSVDataHandling.SortCSV;
import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/SortCSV/employee.csv";

        // Create a list to store the records
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and store the header
            String header = br.readLine();

            // Read the records and add them to the list
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                records.add(columns);
            }

            // Sort the records by the salary column (index 3) in descending order
            records.sort((record1, record2) -> {
                double salary1 = Double.parseDouble(record1[3].trim());
                double salary2 = Double.parseDouble(record2[3].trim());
                return Double.compare(salary2, salary1); // For descending order
            });

            // Print the header
            System.out.println(header);

            // Print the top 5 highest-paid employees
            int count = 0;
            for (String[] record : records) {
                if (count >= 5) break;  // Print only top 5 records
                System.out.print(record[0] + " "); // ID
                System.out.print(record[1] + " "); // Name
                System.out.print(record[2] + " "); // Department
                System.out.println(record[3]);    // Salary
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

