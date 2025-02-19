package org.Capgemini.JSON.PracticeProblem.MergeJSON;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MergeJSON {
    public static void main(String[] args) {
        // Create an instance of Gson to handle JSON parsing
        Gson gson = new Gson();

        // Define two JSON strings (json1 and json2) to represent two JSON objects
        String json1 = "{\"name\": \"Ayush\", \"email\": \"ayush.g@example.com\"}";
        String json2 = "{\"age\": 30, \"address\": \"Bhopal\"}";

        // Parse the first JSON string into a JsonObject (jsonObject1)
        JsonObject jsonObject1 = gson.fromJson(json1, JsonObject.class);

        // Parse the second JSON string into a JsonObject (jsonObject2)
        JsonObject jsonObject2 = gson.fromJson(json2, JsonObject.class);

        // Manually add the fields from jsonObject1 into jsonObject2
        // We can do this directly using 'add()' method without using entrySet().
        jsonObject2.add("name", jsonObject1.get("name"));
        jsonObject2.add("email", jsonObject1.get("email"));

        // Print the merged JSON object
        System.out.println(jsonObject2.toString());
    }
}
