package org.Capgemini.CSVDataHandling.CSVToJavaObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Student class to represent each row of the CSV
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters for the fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Override toString for printing the Student object
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
    }
}

public class CSVToJavaObject {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "D:/IntelliC/Week5/Day1/src/main/java/org/Capgemini/CSVDataHandling/CSVToJavaObject/student,csv";

        // List to store Student objects
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            br.readLine();

            // Read each line and convert it to a Student object
            while ((line = br.readLine()) != null) {
                // Split each line by comma
                String[] columns = line.split(",");

                // Parse data from the columns and create a new Student object
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                double marks = Double.parseDouble(columns[3].trim());

                // Create a Student object and add it to the list
                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

            // Print the list of Student objects
            for (Student student : students) {
                System.out.println(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
