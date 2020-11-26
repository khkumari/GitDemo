package jsonParser;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class MainClass {
    public static void main(String args[]) throws IOException {
        readDataFromJSONFile();

    }
    public static void readDataFromJSONFile() throws IOException {
        //read json file data to String
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Main jsonData =
                objectMapper.readValue(new URL("file:src/main/resources/JSONExample.json"), Main.class);
        System.out.println(jsonData);
        String id = jsonData.getGlossary().getGlossDiv().getGlossList().getGlossEntry().getId();
        System.out.println(id);


        //byte[] jsonData = Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\JSONExample.JSON"));
        //create ObjectMapper instance
        //ObjectMapper objectMapper = new ObjectMapper();
        //read JSON like DOM Parser
        //JsonNode rootNode=objectMapper.readTree(jsonData);

/*        JsonNode titleNode =rootNode.path("title");
        System.out.println(titleNode.asText());*/


    }
}
