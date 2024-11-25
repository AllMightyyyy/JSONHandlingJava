package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class GsonNestedExample {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Creating a Java object with nested objects and collections
        AddressGsonNestedExample address = new AddressGsonNestedExample("4526 Elmza Street", "Dreamland");
        PersonWithHobbies person = new PersonWithHobbies("Zakaria", 22, false, List.of("Football", "BodyBuilding"), address);

        // Convert Java object to JSON
        String jsonString = gson.toJson(person);
        System.out.println("JSON Output:");
        System.out.println(jsonString);

        // Convert JSON back to Java object
        PersonWithHobbies parsedPerson = gson.fromJson(jsonString, PersonWithHobbies.class);
        System.out.println("\nParsed Person:");
        System.out.println(parsedPerson);
    }
}

// Address class
class AddressGsonNestedExample {
    private String street;
    private String city;

    public AddressGsonNestedExample() {}

    public AddressGsonNestedExample(String street, String city) {
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

// PersonWithHobbies class
class PersonWithHobbies {
    private String name;
    private int age;
    private boolean isStudent;
    private List<String> hobbies;
    private AddressGsonNestedExample address;

    public PersonWithHobbies() {}

    public PersonWithHobbies(String name, int age, boolean isStudent, List<String> hobbies, AddressGsonNestedExample address) {
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
        this.hobbies = hobbies;
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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public AddressGsonNestedExample getAddress() {
        return address;
    }

    public void setAddress(AddressGsonNestedExample address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonWithHobbies{name='" + name + "', age=" + age + ", isStudent=" + isStudent +
                ", hobbies=" + hobbies + ", address=" + address + "}";
    }
}