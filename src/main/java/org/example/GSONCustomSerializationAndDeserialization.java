package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class GSONCustomSerializationAndDeserialization {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        User user = new User("Zakaria", "zakaria@example.com");

        // Convert Java object to JSON
        String jsonString = gson.toJson(user);
        System.out.println("JSON Output:");
        System.out.println(jsonString);

        // Convert JSON back to Java object
        User parsedUser = gson.fromJson(jsonString, User.class);
        System.out.println("\nParsed User:");
        System.out.println(parsedUser);
    }
}

// User class with @SerializedName
class User {
    private String name;

    @SerializedName("email_address")
    private String email;

    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}
