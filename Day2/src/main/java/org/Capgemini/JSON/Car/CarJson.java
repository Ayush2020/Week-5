package org.Capgemini.JSON.Car;

import com.google.gson.Gson;


class Car {
    // Instance variables to store car details
    private String brand;
    private String model;
    private String color;

    // Constructor to initialize the car object with brand, model, and color
    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    // Getter method for brand
    public String getBrand() {
        return brand;
    }

    // Getter method for model
    public String getModel() {
        return model;
    }

    // Getter method for color
    public String getColor() {
        return color;
    }

    // Setter method for brand
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Setter method for model
    public void setModel(String model) {
        this.model = model;
    }

    // Setter method for color
    public void setColor(String color) {
        this.color = color;
    }
}

public class CarJson {
    public static void main(String[] args) {
        // Create an instance of the Car class with brand "Mercedes", model "Ford", and color "red"
        Car car = new Car(" BMW ", " M5 CS ", " Magnetic Blue ");

        // Create a Gson object for converting the Car object to JSON
        Gson gson = new Gson();

        // Convert the car object into a JSON string using Gson's toJson method
        String json = gson.toJson(car);

        // Print the JSON string representation of the car object
        System.out.println(json);
    }
}
