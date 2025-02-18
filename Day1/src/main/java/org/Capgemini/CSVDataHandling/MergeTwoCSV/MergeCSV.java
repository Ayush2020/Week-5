package org.Capgemini.CSVDataHandling.MergeTwoCSV;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {

    public static void main(String[] args) {
        // Paths to the input CSV files
        String students1FilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/MergeTwoCSV/student1.csv";
        String students2FilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/MergeTwoCSV/student2.csv";

        // Path to the output CSV file (merged data)
        String mergedFilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/MergeTwoCSV/merge.csv";

        // Map to store data from students1.csv using ID as the key
        Map<Integer, String[]> students1Data = new HashMap<>();

        // Read the first CSV file and store the data in a map
        try (BufferedReader br1 = new BufferedReader(new FileReader(students1FilePath))) {
            String line;
            br1.readLine(); // Skip the header row

            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                int id = Integer.parseInt(columns[0].trim());
                String[] studentDetails = { columns[1].trim(), columns[2].trim() }; // Name, Age
                students1Data.put(id, studentDetails);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the merged data to a new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFilePath))) {
            // Write header for the merged file
            writer.write("ID, Name, Age, Marks, Grade\n");

            // Read the second CSV file and merge data with students1Data
            try (BufferedReader br2 = new BufferedReader(new FileReader(students2FilePath))) {
                String line;
                br2.readLine(); // Skip the header row

                while ((line = br2.readLine()) != null) {
                    String[] columns = line.split(",");
                    int id = Integer.parseInt(columns[0].trim());
                    String marks = columns[1].trim();
                    String grade = columns[2].trim();

                    // Check if the ID exists in the first file's map
                    if (students1Data.containsKey(id)) {
                        String[] studentDetails = students1Data.get(id);
                        String name = studentDetails[0];
                        String age = studentDetails[1];

                        // Write the merged data (ID, Name, Age, Marks, Grade)
                        writer.write(id + ", " + name + ", " + age + ", " + marks + ", " + grade + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV files merged successfully into " + mergedFilePath);
    }
}
