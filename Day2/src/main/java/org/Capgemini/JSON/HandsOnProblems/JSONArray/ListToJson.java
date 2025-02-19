package org.Capgemini.JSON.HandsOnProblems.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (needed for Jackson)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of Student objects
            List<Student> students = Arrays.asList(
                    new Student("Ayush", 21),
                    new Student("Rahul", 22),
                    new Student("Priya", 20)
            );

            // Convert the list to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(students);

            // Print JSON output
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
