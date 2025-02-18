package org.Capgemini.CSVDataHandling.ValidateCSV;
import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/ValidateCSV/validate.csv";

        // Define the email regex pattern for validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Define the phone number regex pattern (must have exactly 10 digits)
        String phoneRegex = "^\\d{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowNum = 1;  // To keep track of the row number

            // Read and process each row
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                // Validate Email (assuming email is in the 3rd column - index 2)
                String email = columns[2].trim();
                Matcher emailMatcher = emailPattern.matcher(email);
                if (!emailMatcher.matches()) {
                    System.out.println("Invalid Email at Row " + rowNum + ": " + email);
                }

                // Validate Phone Number (assuming phone number is in the 4th column - index 3)
                String phone = columns[3].trim();
                Matcher phoneMatcher = phonePattern.matcher(phone);
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid Phone Number at Row " + rowNum + ": " + phone);
                }

                rowNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

