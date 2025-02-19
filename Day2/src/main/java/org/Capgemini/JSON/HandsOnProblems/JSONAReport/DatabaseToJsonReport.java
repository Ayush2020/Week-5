package org.Capgemini.JSON.HandsOnProblems.JSONAReport;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        // Database connection details
        String url = "database";
        String user = "root"; //
        String password = "password";

        // SQL Query
        String query = "SELECT id, name, age, city FROM users";

        // Fetch data and generate JSON
        generateJsonReport(url, user, password, query);
    }

    public static void generateJsonReport(String url, String user, String password, String query) {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // List to store JSON data
            List<Map<String, Object>> dataList = new ArrayList<>();

            // Get metadata to dynamically read columns
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Fetch rows from the database
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                dataList.add(row);
            }

            // Convert list to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File("report.json");
            objectMapper.writeValue(jsonFile, dataList);

            System.out.println("JSON Report Generated Successfully: " + jsonFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
