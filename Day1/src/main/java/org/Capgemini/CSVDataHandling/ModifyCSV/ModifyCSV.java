package org.Capgemini.CSVDataHandling.ModifyCSV;
import org.apache.commons.collections.Buffer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModifyCSV{
    public static void main(String[] args) {
        String file = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/ModifyCSV/employee.csv";
        String updateFile = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/ModifyCSV/update.csv";
        List<String> updateData = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String header = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].trim().equalsIgnoreCase("IT")) {
                    double sal = Double.parseDouble(columns[3].trim());
                    double updateSal = sal * 1.10;
                    columns[3] = String.format("%.2f", updateSal);
                }
                String updateLine = String.join(",", columns);
                updateData.add(updateLine);
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(updateFile))){
                for (String record : updateData) {
                    writer.write(record);
                    writer.newLine();
                }
            }
            System.out.println("Updated file Sucessfully");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}



