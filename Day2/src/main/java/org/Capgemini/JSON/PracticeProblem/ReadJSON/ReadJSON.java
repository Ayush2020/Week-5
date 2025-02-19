package org.Capgemini.JSON.PracticeProblem.ReadJSON;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileReader;
import java.io.IOException;

public class ReadJSON {
    public static void main(String[] args) {
        // Start of the try-catch block for exception handling
        try {
            // Create a Gson object to handle JSON parsing
            Gson gson = new Gson();

            // Specify the path to the JSON file (ensure this is correct in your system)
            String file = "D:/IntelliC/Week5/Day2/src/main/java/org/Capgemini/JSON/PracticeProblem/ReadJSON/read.json";

            // Create a FileReader to read the contents of the JSON file
            FileReader reader = new FileReader(file);

            // Parse the JSON file content into a JsonObject using Gson
            JsonObject json = gson.fromJson(reader, JsonObject.class);

            // Extract the value of the "name" field from the JsonObject
            String name = json.get("name").getAsString();

            // Extract the value of the "email" field from the JsonObject
            String email = json.get("email").getAsString();

            // Print the extracted values to the console
            System.out.println(name);
            System.out.println(email);
        } catch (IOException e) {
            // If an error occurs while reading the file, print the stack trace
            e.printStackTrace();
        }
    }
}

