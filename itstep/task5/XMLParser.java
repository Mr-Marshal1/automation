package itstep.task5;

import com.fasterxml.jackson.core.JsonProcessingException;
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
public class XMLParser {
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

        // object to xml String
        XmlMapper xmlMapper = new XmlMapper();
        String stringXML=xmlMapper.writeValueAsString(color);
        System.out.println("stringXML: " + stringXML);

        // step 3 read xml file to object
        Color inputXmlUser=xmlMapper.readValue(new File("input.xml"), Color.class);
        System.out.println("inputXmlColor: " + inputXmlUser);

        // step 4 change data and save to xml file
        inputXmlUser.getColors().add("white");
        xmlMapper.writeValue(new File("output.xml"), inputXmlUser);
        System.out.println("Updated inputxmlColor: " + inputXmlUser);
    }
}