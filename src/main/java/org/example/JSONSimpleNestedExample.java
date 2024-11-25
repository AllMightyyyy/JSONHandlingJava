import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONSimpleNestedExample {
    public static void main(String[] args) {
        // Creating a nested JSON object
        JSONObject address = new JSONObject();
        address.put("street", "789 Pine St");
        address.put("city", "Fantasia");

        JSONArray hobbies = new JSONArray();
        hobbies.add("Gaming");
        hobbies.add("Cycling");

        JSONObject person = new JSONObject();
        person.put("name", "Leo");
        person.put("age", 28);
        person.put("isStudent", false);
        person.put("hobbies", hobbies);
        person.put("address", address);

        System.out.println("JSON Output:");
        System.out.println(person.toJSONString());

        // Parsing the nested JSON
        String jsonString = person.toJSONString();

        JSONParser parser = new JSONParser();
        try {
            JSONObject parsedPerson = (JSONObject) parser.parse(jsonString);
            System.out.println("\nParsed Person:");
            System.out.println("Name: " + parsedPerson.get("name"));
            System.out.println("City: " + ((JSONObject) parsedPerson.get("address")).get("city"));
            System.out.println("Hobbies: " + parsedPerson.get("hobbies"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
