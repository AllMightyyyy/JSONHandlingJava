package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONSimpleExample {
    public static void main(String[] args) {
        // Creating a JSON object
        JSONObject person = new JSONObject();
        person.put("name", "Jack");
        person.put("age", 32);
        person.put("isStudent", false);

        System.out.println("JSON Output:");
        System.out.println(person.toJSONString());

        // Parsing JSON string
        String jsonString = "{\"name\":\"Karen\",\"age\":26,\"isStudent\":true}";
        // This can be a file read using a buffered reader or the Files.readAllBytes method ( implemented here for simplicity )

        JSONParser parser = new JSONParser();
        try {
            JSONObject parsedPerson = (JSONObject) parser.parse(jsonString);
            System.out.println("\nParsed Person:");
            System.out.println("Name: " + parsedPerson.get("name"));
            System.out.println("Age: " + parsedPerson.get("age"));
            System.out.println("Is Student: " + parsedPerson.get("isStudent"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
