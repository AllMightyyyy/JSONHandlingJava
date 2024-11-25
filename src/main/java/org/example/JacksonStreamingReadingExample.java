package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.File;
import java.io.IOException;

public class JacksonStreamingReadingExample {
    public static void main(String[] args) {
        JsonFactory factory = new JsonFactory();
        File jsonFile = new File("large-data.json"); // Large JSON FILE

        try (JsonParser parser = factory.createParser(jsonFile)) {
            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(token)) {
                    String fieldName = parser.getCurrentName();
                    parser.nextToken();

                    if ("name".equals(fieldName)) {
                        String name = parser.getValueAsString();
                        System.out.println("Name: " + name);
                    } else if ("age".equals(fieldName)) {
                        int age = parser.getIntValue();
                        System.out.println("Age: " + age);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
