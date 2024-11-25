package org.example;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HandlingExceptionJsonParsing {
    public static void main(String[] args) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get("HandlingMalformedJSON.json")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        try {
            JSONObject person = new JSONObject(content);
        } catch (JSONException e) {
            System.out.println("JSON parsing error: " + e.getMessage());
            /*
            This outputs : JSON parsing error: A JSONObject text must end with '}' at 27 [character 28 line 1]
             */
        }
    }
}
