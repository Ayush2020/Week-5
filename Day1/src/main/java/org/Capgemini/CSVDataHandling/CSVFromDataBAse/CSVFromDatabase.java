package org.Capgemini.CSVDataHandling.CSVFromDataBAse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CSVFromDatabase {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/yourDatabase";
        String dbUsername = "yourUsername";
        String dbPassword = "yourPassword";
        String outputCsvFile = "D:/IntelliC/Week5/Day1/src/main//java/org/Capgemini/CSVDataHandling/CSVFromDataBAse/output.csv";


        // Establish the database connection
        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {

            // Prepare SQL query to fetch employee records
            String query = "SELECT employee_id, name, department, salary FROM employees";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                // Prepare BufferedWriter to write to CSV file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {
                    // Write the header line to CSV
                    writer.write("Employee ID, Name, Department, Salary\n");

                    // Write each record from the ResultSet to the CSV file
                    while (rs.next()) {
                        int employeeId = rs.getInt("employee_id");
                        String name = rs.getString("name");
                        String department = rs.getString("department");
                        double salary = rs.getDouble("salary");

                        // Write the record to the CSV
                        writer.write(employeeId + ", " + name + ", " + department + ", " + salary + "\n");
                    }

                    System.out.println("CSV report generated successfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
