package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonAnnotationCustomization {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = new Employee("Zakaria", "Developer", 250000);

        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            System.out.println("JSON Output:");
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
    }
}

// Employee class with annotations
class Employee {
    private String name;

    @JsonProperty("position")
    private String jobTitle;

    @JsonIgnore
    private int salary;

    public Employee() {}

    public Employee(String name, String jobTitle, int salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}