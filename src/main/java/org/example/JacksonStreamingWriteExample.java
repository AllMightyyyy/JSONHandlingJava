package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.File;
import java.io.IOException;

public class JacksonStreamingWriteExample {
    public static void main(String[] args) {
        JsonFactory factory = new JsonFactory();
        File outputFile = new File("output-streaming.json");

        try (JsonGenerator generator = factory.createGenerator(outputFile, com.fasterxml.jackson.core.JsonEncoding.UTF8)) {
            generator.useDefaultPrettyPrinter();

            generator.writeStartObject();
            generator.writeNumberField("id", 202);
            generator.writeStringField("name", "Peter");

            generator.writeFieldName("scores");
            generator.writeStartArray();
            generator.writeNumber(85);
            generator.writeNumber(90);
            generator.writeNumber(95);
            generator.writeEndArray();

            generator.writeEndObject();

            System.out.println("JSON file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
