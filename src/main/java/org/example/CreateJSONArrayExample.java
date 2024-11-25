package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONArrayExample {
    public static void main(String[] args) {
        JSONArray courses = new JSONArray();
        courses.put("Math");
        courses.put("Physics");

        JSONObject student = new JSONObject();
        student.put("name", "Zakaria");
        student.put("age", 22);
        student.put("courses", courses);

        System.out.println(student.toString(4));
    }
}
