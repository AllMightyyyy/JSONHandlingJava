package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class JacksonMergeExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String json1 = "{ \"name\": \"Rachel\", \"age\": 30 }";
        String json2 = "{ \"email\": \"rachel@example.com\", \"age\": 31 }"; // Note: 'age' is duplicated

        try {
            JsonNode node1 = mapper.readTree(json1);
            JsonNode node2 = mapper.readTree(json2);

            ObjectNode merged = ((ObjectNode) node1).deepCopy();
            merged.setAll((ObjectNode) node2); // Fields from node2 overwrite node1

            String mergedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(merged);
            System.out.println("Merged JSON:");
            System.out.println(mergedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
