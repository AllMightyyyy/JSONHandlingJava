package org.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;

public class JacksonCustomSerializerExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Register custom serializer
        SimpleModule module = new SimpleModule();
        module.addSerializer(UserCustom.class, new UserCustomSerializer());
        mapper.registerModule(module);

        UserCustom user = new UserCustom("Quentin", 35, "secret");

        // Serialize with custom serializer
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println("Custom Serialized JSON:");
        System.out.println(jsonString);
    }
}

// User class
class UserCustom {
    private String name;
    private int age;
    private String password;

    public UserCustom() {}

    public UserCustom(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Custom Serializer for User
class UserCustomSerializer extends JsonSerializer<UserCustom> {
    @Override
    public void serialize(UserCustom user, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", user.getName());
        gen.writeNumberField("age", user.getAge());
        // Exclude password or handle it differently
        gen.writeEndObject();
    }
}
