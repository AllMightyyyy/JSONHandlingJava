package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ComplexJSONJacksonExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "{\n" +
                "    \"id\": 101,\n" +
                "    \"name\": \"Rachel\",\n" +
                "    \"contact\": {\n" +
                "        \"email\": \"rachel@example.com\",\n" +
                "        \"phone\": \"123-456-7890\"\n" +
                "    },\n" +
                "    \"roles\": [\"admin\", \"user\"],\n" +
                "    \"preferences\": {\n" +
                "        \"notifications\": {\n" +
                "            \"email\": true,\n" +
                "            \"sms\": false\n" +
                "        },\n" +
                "        \"theme\": \"dark\"\n" +
                "    }\n" +
                "}";

        try {
            UserComplex user = mapper.readValue(jsonString, UserComplex.class);
            System.out.println("Parsed User:");
            System.out.println(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

// User class with nested objects
class UserComplex {
    private int id;
    private String name;
    private Contact contact;
    private String[] roles;
    private Preferences preferences;

    public UserComplex() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', contact=" + contact +
                ", roles=" + String.join(", ", roles) +
                ", preferences=" + preferences + "}";
    }
}

// Contact class
class Contact {
    private String email;
    private String phone;

    public Contact() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{email='" + email + "', phone='" + phone + "'}";
    }
}

// Preferences class
class Preferences {
    private Notifications notifications;
    private String theme;

    public Preferences() {}

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Preferences{notifications=" + notifications + ", theme='" + theme + "'}";
    }
}

// Notifications class
class Notifications {
    private boolean email;
    private boolean sms;

    public Notifications() {}

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    @Override
    public String toString() {
        return "Notifications{email=" + email + ", sms=" + sms + "}";
    }
}
