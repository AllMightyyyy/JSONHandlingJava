package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JacksonDynamicExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{ \"key1\": \"value1\", \"key2\": 42, \"key3\": { \"subKey\": \"subValue\" } }";

        try {
            JsonNode rootNode = mapper.readTree(jsonString);

            // Accessing dynamic fields
            String key1 = rootNode.get("key1").asText();
            int key2 = rootNode.get("key2").asInt();
            String subKey = rootNode.get("key3").get("subKey").asText();

            System.out.println("key1: " + key1);
            System.out.println("key2: " + key2);
            System.out.println("subKey: " + subKey);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
