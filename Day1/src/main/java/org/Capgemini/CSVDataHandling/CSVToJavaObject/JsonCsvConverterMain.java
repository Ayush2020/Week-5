package org.Capgemini.CSVDataHandling.CSVToJavaObject;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import static java.lang.System.out;

class CsvToJsonConverter {
    public static void convert(String csvFilePath, String jsonFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            // read header
            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.out.println("csv file is empty: " + csvFilePath);
                return;
            }
            String[] headers = headerLine.split(",");

            // read data and convert to json array
            JSONArray jsonArray = new JSONArray();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }

            // write json file
            Files.write(Paths.get(jsonFilePath), jsonArray.toString(4).getBytes(StandardCharsets.UTF_8));
            System.out.println("csv converted to json successfully: " + jsonFilePath);
        } catch (Exception e) {
            System.out.println("error while converting csv to json: " + e.getMessage());
        }
    }
}


class JsonToCsvConverter {
    public static void convert(String jsonFilePath, String csvFilePath) {
        try {
            // read json file
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)), StandardCharsets.UTF_8);
            if (content.trim().isEmpty()) {
                out.println("json file is empty: " + jsonFilePath);
                return;
            }

            // parse json array
            JSONArray jsonArray = new JSONArray(content);

            // write csv file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
                // write header
                JSONObject obj = jsonArray.getJSONObject(0);
                String[] keys = JSONObject.getNames(obj);
                writer.write(String.join(",", keys));
                writer.newLine();

                // write data
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObj = jsonArray.getJSONObject(i);
                    String[] values = new String[keys.length];
                    for (int j = 0; j < keys.length; j++) {
                        values[j] = jsonObj.get(keys[j]).toString();
                    }
                    writer.write(String.join(",", values));
                    writer.newLine();
                }
                out.println("json converted to csv successfully: " + csvFilePath);
            }
        } catch (Exception e) {
            out.println("error while converting json to csv: " + e.getMessage());
        }
    }
}

public class JsonCsvConverterMain {
    public static void main(String[] args) {
        //define file path
        String jsonFilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/CSVToJavaObject/student.json";
        String csvFilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/CSVToJavaObject/student.csv" +
                "";
        String outputJsonFilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/CSVToJavaObject/output.json";

        // convert csv back to json
        CsvToJsonConverter.convert(csvFilePath, outputJsonFilePath);
        // convert json to csv
        JsonToCsvConverter.convert(jsonFilePath, csvFilePath);
    }

}