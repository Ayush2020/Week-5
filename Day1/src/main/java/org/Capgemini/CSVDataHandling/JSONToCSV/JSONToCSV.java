//package org.Capgemini.CSVDataHandling.JSONToCSV;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.*;
//import java.util.*;
//
//public class JsonCsvConversion {
//
//    // Method to convert JSON to CSV
//    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
//        try {
//            // Read the JSON file
//            BufferedReader reader = new BufferedReader(new FileReader(jsonFilePath));
//            String jsonContent = "";
//            String line;
//            while ((line = reader.readLine()) != null) {
//                jsonContent += line;
//            }
//
//            // Convert the JSON string to a JSON array
//            JSONArray jsonArray = new JSONArray(jsonContent);
//            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));
//
//            // Write the header
//            writer.write("ID, Name, Age, Department, Marks\n");
//
//            // Write data rows
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject student = jsonArray.getJSONObject(i);
//                writer.write(student.getInt("id") + ", ");
//                writer.write(student.getString("name") + ", ");
//                writer.write(student.getInt("age") + ", ");
//                writer.write(student.getString("department") + ", ");
//                writer.write(student.getInt("marks") + "\n");
//            }
//
//            writer.close();
//            System.out.println("CSV file created successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Method to convert CSV to JSON
//    public static void csvToJson(String csvFilePath, String jsonFilePath) {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
//            String line;
//            List<JSONObject> students = new ArrayList<>();
//
//            // Skip the header
//            reader.readLine();
//
//            // Read CSV rows and create JSON objects
//            while ((line = reader.readLine()) != null) {
//                String[] columns = line.split(", ");
//                JSONObject student = new JSONObject();
//                student.put("id", Integer.parseInt(columns[0]));
//                student.put("name", columns[1]);
//                student.put("age", Integer.parseInt(columns[2]));
//                student.put("department", columns[3]);
//                student.put("marks", Integer.parseInt(columns[4]));
//                students.add(student);
//            }
//
//            // Convert List<JSONObject> to JSONArray
//            JSONArray jsonArray = new JSONArray(students);
//
//            // Write the JSON array to file
//            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath));
//            writer.write(jsonArray.toString(4));  // Pretty print with indent 4
//            writer.close();
//            System.out.println("JSON file created successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        // Convert JSON to CSV
//        jsonToCsv("students.json", "students.csv");
//
//        // Convert CSV to JSON
//        csvToJson("students.csv", "students_converted.json");
//    }
//}
//
