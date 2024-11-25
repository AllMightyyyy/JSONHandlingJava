package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class JacksonDeepCopyExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String originalJson = "{ \"name\": \"Sam\", \"details\": { \"age\": 28, \"city\": \"Metropolis\" } }";

        try {
            JsonNode originalNode = mapper.readTree(originalJson);
            JsonNode deepCopyNode = originalNode.deepCopy();

            // Modify the deep copy
            ((ObjectNode) deepCopyNode).put("name", "Samuel");
            ((ObjectNode) deepCopyNode.get("details")).put("city", "Gotham");

            System.out.println("Original JSON:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(originalNode));

            System.out.println("\nDeep Copied and Modified JSON:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(deepCopyNode));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
