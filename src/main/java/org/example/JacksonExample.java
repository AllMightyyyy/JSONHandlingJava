package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        // Create a Java Object
        Person person = new Person("Zakaria", 22, true);

        try {
            // Convert Java Object to JSON String
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
            System.out.println("JSON Output :");
            System.out.println(jsonString);

            // Convert JSON String back to Java Object
            Person parsedPerson = mapper.readValue(jsonString, Person.class);
            System.out.println("\nParsed Person:");
            System.out.println(parsedPerson);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
    }
}

// Person class
class Person {
    private String name;
    private int age;
    private boolean isStudent;

    public Person() {}

    public Person(String name, int age, boolean isStudent) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }

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

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", isStudent=" + isStudent + "}";
    }
}
