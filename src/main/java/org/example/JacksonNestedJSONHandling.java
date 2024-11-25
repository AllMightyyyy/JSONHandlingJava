package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JacksonNestedJSONHandling {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        // Create a Java Object with nested objects and collections
        Address address = new Address("123 New York Boulevard", "Paris");
        PersonWithCourses person = new PersonWithCourses("Zakaria", 22, false, List.of("Maths", "Physics"), address);
        try {
            // Convert Java Object to JSON
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
            System.out.println("JSON OUTPUT :");
            System.out.println(jsonString);

            // Convert JSON back into Java Object
            PersonWithCourses parsedPerson = mapper.readValue(jsonString, PersonWithCourses.class);
            System.out.println("\nParsed Person:");
            System.out.println(parsedPerson);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
    }
}

// Address class
class Address {
    private String street;
    private String city;

    public Address() {}

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{street='" + street + "', city='" + city + "'}";
    }
}

// PersonWithCourses class
class PersonWithCourses {
    private String name;
    private int age;
    private boolean isStudent;
    private List<String> courses;
    private Address address;

    public PersonWithCourses() {}

    public PersonWithCourses(String name, int age, boolean isStudent, List<String> courses, Address address) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
        this.courses = courses;
        this.address = address;
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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonWithCourses{name='" + name + "', age=" + age + ", isStudent=" + isStudent +
                ", courses=" + courses + ", address=" + address + "}";
    }
}
