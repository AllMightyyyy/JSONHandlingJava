package org.example;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParsingJSONExample {
    public static void main(String[] args) throws IOException {
        String jsonContent = new String(Files.readAllBytes(Paths.get("ParsingJSONExample.json")));
        JSONObject person = new JSONObject(jsonContent);
        System.out.println(person.getString("name")); // Outputs : "Zakaria"
        System.out.println(person.getString("age")); // Outputs : 22
        System.out.println(person.getString("isStudent")); // Outputs : true
    }
}
