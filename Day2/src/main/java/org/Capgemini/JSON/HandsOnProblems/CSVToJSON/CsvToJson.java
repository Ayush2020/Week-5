package org.Capgemini.JSON.HandsOnProblems.CSVToJSON;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class CsvToJson {
    public static void main(String[] args) {
        // Input CSV file and Output JSON file
        File csvFile = new File("data.csv");
        File jsonFile = new File("data.json");

        // Convert CSV to JSON
        convertCsvToJson(csvFile, jsonFile);
    }

    public static void convertCsvToJson(File csvFile, File jsonFile) {
        try {
            // Create CsvMapper and Schema
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // Reads the first row as headers

            // Read CSV data into List of Maps
            MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class).with(schema).readValues(csvFile);
            List<Map<String, String>> data = it.readAll();

            // Convert to JSON and   write to file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(jsonFile, data);

            System.out.println("CSV successfully converted to JSON!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
