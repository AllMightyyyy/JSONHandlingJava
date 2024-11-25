package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSONExample {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Creating a Java Object
        Student student = new Student("Zakaria", 22, true);
        // Convert Java Object to JSON
        String jsonString = gson.toJson(student);
        System.out.println("JSON OUTPUT :");
        System.out.println(jsonString);
        // Convert JSON back to Java Object
        Student parsedStudent = gson.fromJson(jsonString, Student.class);
        System.out.println("\nParsed Student:");
        System.out.println(parsedStudent);
    }
}

// Student class
class Student {
    private String name;
    private int age;
    private boolean isStudent;

    public Student() {}

    public Student(String name, int age, boolean isStudent) {
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
        return "Student{name='" + name + "', age=" + age + ", isStudent=" + isStudent + "}";
    }
}
