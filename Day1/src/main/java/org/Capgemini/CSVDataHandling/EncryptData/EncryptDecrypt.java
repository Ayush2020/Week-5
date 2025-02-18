package org.Capgemini.CSVDataHandling.EncryptData;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class EncryptDecrypt {

    private static String encrypt(String data)
    {
        StringBuilder sb = new StringBuilder();
        int shift = 3;
        for (char ch : data.toCharArray())
        {
            sb.append((char) (ch + shift));
        }
        return sb.toString();
    }

    private static String decrypt(String data) {
        StringBuilder sb = new StringBuilder();
        int shift = 3;
        for (char ch : data.toCharArray())
        {
            sb.append((char) (ch - shift));
        }
        return sb.toString();
    }
    private static void encryptCsvData(String inputFilePath, String outputFilePath)
    {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath)); CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath)))
        {

            String[] row;
            boolean isHeader = true;
            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    writer.writeNext(row);
                    isHeader = false;
                    continue;
                }
                // encrypt email and number
                row[1] = encrypt(row[1]);
                row[2] = encrypt(row[2]);

                writer.writeNext(row);
            }
            out.println("csv file written with encrypted data");
        } catch (IOException | CsvValidationException e) {
            out.println("exception- " + e.getMessage());
        }
    }
    private static void readAndDecryptCsv(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            boolean isHeader = true;
            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    out.println("\nid, email, number");
                    isHeader = false;
                    continue;
                }
                // decrypt sensitive email and number
                row[1] = decrypt(row[1]);
                row[2] = decrypt(row[2]);
                out.println(String.join(", ", row));
            }
        } catch (IOException | CsvValidationException e) {
            out.println("exception- " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // define input and output file paths
        String inputFilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/EncryptData/decrypt.csv";
        String encryptedFilePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/EncryptData/encrypt.csv";

        //encrypt csv data
        encryptCsvData(inputFilePath, encryptedFilePath);

        //read encrypted csv data
        out.println("\nreading encrypted data");
        readAndDecryptCsv(encryptedFilePath);
    }
}
