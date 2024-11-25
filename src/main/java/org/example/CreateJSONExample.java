package org.example;

import org.json.JSONObject;

public class CreateJSONExample {
    public static void main(String[] args) {
        /*
        org.json library is used in this example ( lightweight lib for parsing and generating JSON in Java )
         */
        JSONObject person = new JSONObject();
        person.put("name", "Zakaria");
        person.put("age", 22);
        person.put("isStudent", true);

        System.out.println(person.toString(4)); // Print with indent Factor to look kind of pretty :D
    }
}