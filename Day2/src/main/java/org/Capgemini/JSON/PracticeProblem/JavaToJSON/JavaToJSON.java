package org.Capgemini.JSON.PracticeProblem.JavaToJSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;

// Defining the Student class
class Student {
    private String name;
    private int age;

    // Constructor to initialize Student object
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter method for 'name' field
    public String getName() {
        return name;
    }

    // Getter method for 'age' field
    public int getAge() {
        return age;
    }

    // Setter method for 'name' field
    public void setName(String name) {
        this.name = name;
    }

    // Setter method for 'age' field
    public void setAge(int age) {
        this.age = age;
    }
}

// Main class where program execution begins
public class JavaToJSON {
    public static void main(String[] args) {
        try {
            // Creating a list of Student objects
            List<Student> students = Arrays.asList(
                    new Student("Ayush", 21),
                    new Student("Rahul", 22),
                    new Student("Priya", 20)
            );

            // Creating an ObjectMapper instance for JSON conversion
            ObjectMapper objectMapper = new ObjectMapper();

            // Converting the list of Student objects to a JSON array
            String jsonArray = objectMapper.writeValueAsString(students);

            // Printing the JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            // Handling any exceptions that may occur
            e.printStackTrace();
        }
    }
}
