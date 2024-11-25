package org.example;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.ValidationException;

import java.util.Objects;

public class JSONValidationExample {
    public static void main(String[] args) {
        // Load JSON Schema
        JSONObject jsonSchema = new JSONObject(new JSONTokener(
                Objects.requireNonNull(JSONValidationExample.class.getResourceAsStream("/person-schema.json"))
        ));
        Schema schema = SchemaLoader.load(jsonSchema);

        // Valid JSON data
        String validJsonData = "{ \"name\": \"Olivia\", \"age\": 25, \"isStudent\": true }";

        // Invalid JSON data (missing required field 'isStudent')
        String invalidJsonData = "{ \"name\": \"Paul\", \"age\": 30 }";

        // Validate valid JSON
        try {
            JSONObject jsonData = new JSONObject(validJsonData);
            schema.validate(jsonData);
            System.out.println("Valid JSON data is valid.");
        } catch (ValidationException e) {
            System.out.println("Valid JSON data is invalid: " + e.getMessage());
        }

        // Validate invalid JSON
        try {
            JSONObject jsonData = new JSONObject(invalidJsonData);
            schema.validate(jsonData);
            System.out.println("Invalid JSON data is valid.");
        } catch (ValidationException e) {
            System.out.println("Invalid JSON data is invalid: " + e.getMessage());
        }
    }
}
