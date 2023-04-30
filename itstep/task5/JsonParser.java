package itstep.task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

// Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read json from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for xml.
public class JsonParser {
    public static void main(String[] args) throws IOException {
        // a) Make some complex models using your variant.
        String jsonStr = "{\r\n" +
                "  \"colors\": [\"red\", \"green\", \"blue\"],\r\n" +
                "  \"isPrimary\": true,\r\n" +
                "  \"rgb\": {\r\n" +
                "    \"r\": 255,\r\n" +
                "    \"g\": 0,\r\n" +
                "    \"b\": 0\r\n" +
                "  }\r\n" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Color color = objectMapper.readValue(jsonStr, Color.class);
        System.out.println(color);

        // object to JSON String
        ObjectMapper ObjectMapper = new ObjectMapper();
        String stringJSON=ObjectMapper.writeValueAsString(color);
        System.out.println("stringjson: " + stringJSON);

        // step 3 read json file to object
        Color inputJSONUser=objectMapper.readValue(new File("input.json"), Color.class);
        System.out.println("inputJSONColor: " + inputJSONUser);

        // step 4 change data and save to json file
        inputJSONUser.getColors().add("white");
        objectMapper.writeValue(new File("output.json"), inputJSONUser);
        System.out.println("Updated inputJSONuser: " + inputJSONUser);
    }
}